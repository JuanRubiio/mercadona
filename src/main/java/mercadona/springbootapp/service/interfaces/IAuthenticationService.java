package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import mercadona.springbootapp.dto.TokenLoginDTO;
import mercadona.springbootapp.exception.RestException;

public interface IAuthenticationService {

	TokenLoginDTO login(String paramString1, String paramString2, HttpServletRequest request) throws IOException, RestException;

}
