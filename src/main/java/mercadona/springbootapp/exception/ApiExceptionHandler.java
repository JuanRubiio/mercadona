package mercadona.springbootapp.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mercadona.springbootapp.common.StandarizedApiExceptionResponse;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(RestException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleBussinesRuleException(RestException ex) {
	    StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getCode(), ex.getMessage());
	    return new ResponseEntity<StandarizedApiExceptionResponse>(response, (ex.getHttpStatus().equals(HttpStatus.UNAUTHORIZED) && !ex.isLogin()) ? HttpStatus.INTERNAL_SERVER_ERROR : ex.getHttpStatus());
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleBussinesRuleException(IOException ex) {
	    StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("500", ex.getMessage());
	    return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
     
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleUnknownHostException(Exception ex) {
    	StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("500", "Internal server error");
        return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
    }

}
