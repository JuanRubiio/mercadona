package mercadona.springbootapp.security;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import mercadona.springbootapp.entity.User;
import mercadona.springbootapp.repository.UserRepository;
import mercadona.springbootapp.utils.Constantes;
import mercadona.springbootapp.utils.Utilidades;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	/** The log */
	private static Log log = LogFactory.getLog(JWTAuthorizationFilter.class);
	
	private Environment env;

	private UserRepository userRepository;
	
	public JWTAuthorizationFilter(UserRepository userRepository, Environment env) {
		super();
		this.userRepository = userRepository;
		this.env = env;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	throws ServletException, IOException {
	
		log.info("Access to JWTAuthorizationFilter");
		log.info("access-token --> " +  request.getHeader(Constantes.AUTH_HEADER));
		User session = null;
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		
		try {
			if (!isAuthWhiteList(request) && existeJWTToken(request, response)) {
				Claims claims = Utilidades.validarJWT(request.getHeader(Constantes.AUTH_HEADER), env);
				log.info("Claims del token --> " + claims.toString());
				
				if (claims.getSubject() != null) {
					session = getSessionById(claims.getSubject());
					if (session != null) {
							setUpSpringAuthentication(claims);
							response.setHeader(Constantes.AUTH_HEADER, request.getHeader(Constantes.AUTH_HEADER));
					} else {
						log.error("No hay sesión para el usuario --> " + claims.getSubject());
						SecurityContextHolder.clearContext();
					}
					
				} else {
					log.error("AccesToken informado sin campo subject");
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
			
			chain.doFilter(request, response);
			
		} catch (ExpiredJwtException e) {
			log.info("Token expirado");
			long maxExp = Long.parseLong(this.env.getProperty(Constantes.AUTH_MAX_TIME_INACTIVITY));
			Claims claims = Utilidades.getClaimsJWT(request.getHeader(Constantes.AUTH_HEADER));
			log.info("Claims obtenido: " + claims.toString());
			long resta = (System.currentTimeMillis() - claims.getIssuedAt().getTime()) / 60000;
			log.info("Tiempo de inactividad: " + resta);
			if(resta < maxExp) {
				session = getSessionById(claims.getSubject());
				if (session!=null) {
						setUpSpringAuthentication(claims);
//							response.setHeader(Constantes.AUTH_HEADER, res.getAccessToken());
						chain.doFilter(request, response);
				}
				else {
					log.error("No hay sesión guardada en Redis para el usuario --> " + claims.getSubject());
					((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
				}	
			} else {
				log.info("Superado tiempo de inactividad");
//				this.userRepository.deleteById(claims.getSubject());
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
			}
		} catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException | IOException | CertificateException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			log.error("Se ha producido un error: " + e.getMessage());
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
		}
		
	}
	
	private boolean isAuthWhiteList(HttpServletRequest request) {
		boolean pathFound = false;
		String path = request.getRequestURI();
		log.info("Path --> " + path);
		String[] whiteList = env.getProperty(Constantes.AUTH_WHITELIST).split(Constantes.SEPARATOR);

		for(String reg : whiteList) {
			pathFound = path.contains(reg.replace("**", ""));
			if(pathFound) break;
		}
		return pathFound;
	}
	
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(Constantes.AUTH_HEADER);
		return authenticationHeader != null;
	}
	
	private User getSessionById(String id){
		Optional<User> session = null;
		User info = null;
		try {
			session = this.userRepository.findByUsername(id);
			info = session.get();
		}catch (Exception e) {}
		return info;
	}
	
	/**
	 * Metodo para autenticarnos dentro del flujo de Spring
	 * 
	 * @param claims
	 */
	private void setUpSpringAuthentication(Claims claims) {
		/*@SuppressWarnings("unchecked")
		List<String> authorities = (List) claims.get("authorities");*/

		/*UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));*/
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, new ArrayList<>());
		SecurityContextHolder.getContext().setAuthentication(auth);

	}


}
