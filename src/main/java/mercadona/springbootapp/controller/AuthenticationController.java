package mercadona.springbootapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IAuthenticationController;
import mercadona.springbootapp.dto.LoginForm;
import mercadona.springbootapp.dto.TokenLoginDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.UserRepository;
import mercadona.springbootapp.service.interfaces.IAuthenticationService;


@RestController
@CrossOrigin
public class AuthenticationController implements IAuthenticationController {

	@Autowired
	IAuthenticationService authenticationService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<TokenLoginDTO> login(HttpServletRequest request, LoginForm login)
			throws IOException, RestException {
		
//		log.info("Aceso al controlador de login para el usuario --> " + login.getUser());
		
		long startTime = System.nanoTime();
		
		ResponseEntity<TokenLoginDTO> response = null;
		
//		final ResponseAccessTokens token = autenticationService.login(login.getUser(), login.getPass(), request);
//
//		if (token.getAccessToken() != null && token.getRefreshToken() != null) {
//				
//			TokenLoginDTO res = new TokenLoginDTO();
//			res.setToken(token.getAccessToken());
//			
//			response = ResponseEntity.ok(res);
//			
//		} else {
//			log.error("No se ha podido obtener el accessToken del servicio de login");
//			throw new BusinessRestException(null, null, HttpStatus.UNAUTHORIZED);
//		}
//			
//		long endTime = System.nanoTime();
//		long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
//		
//		log.info("The request to login(" + login.getUser() + ") took " + duration + " ms.");
		return response;
	}
}
