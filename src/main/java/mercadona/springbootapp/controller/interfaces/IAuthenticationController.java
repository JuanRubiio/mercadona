package mercadona.springbootapp.controller.interfaces;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mercadona.springbootapp.common.StandarizedApiExceptionResponse;
import mercadona.springbootapp.dto.LoginForm;
import mercadona.springbootapp.dto.TokenLoginDTO;
import mercadona.springbootapp.exception.RestException;


public interface IAuthenticationController {
	
	
	@Operation(summary = "login", description = "Login by user and password", tags={ "Security" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Everything is ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenLoginDTO.class))),
            
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))),
            
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandarizedApiExceptionResponse.class))) })
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<TokenLoginDTO> login(HttpServletRequest request, @RequestBody LoginForm login) throws IOException, RestException;
	
	

}
