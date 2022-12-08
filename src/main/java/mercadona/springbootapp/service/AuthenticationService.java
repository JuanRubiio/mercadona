package mercadona.springbootapp.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import mercadona.springbootapp.dto.TokenLoginDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.UserRepository;
import mercadona.springbootapp.service.interfaces.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService{
	
	private static Log log = LogFactory.getLog(IAuthenticationService.class);

	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	private Environment env;
	
	@Override
	public TokenLoginDTO login(String user, String pass, HttpServletRequest request) throws IOException, RestException {
		
		TokenLoginDTO res = null;
//		User redisSession = new User();
//		
//		try {
//			res = this.securityService.accessToken(new RequestAccessToken(user, pass));
//		}catch (RestException e) {
//			e.setLogin(true);
//			throw e;
//		}
//		
//		Claims claims = Utilidades.getClaimsJWT(res.getAccessToken());
//		redisSession.setId(claims.getSubject());
//		redisSession.setRefreshToken(res.getRefreshToken());
//		
//		//Save Redis session
//		userRepository.save(redisSession);
		
		return res;
	}

}
