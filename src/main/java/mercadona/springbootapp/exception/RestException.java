package mercadona.springbootapp.exception;

import org.springframework.http.HttpStatus;

public class RestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;   
    private HttpStatus httpStatus;
    private boolean isLogin;
    
    
	public RestException(String message, String code, HttpStatus httpStatus) {
		super(message);
		this.code = code;
		this.httpStatus = httpStatus;
		this.isLogin = false;
	}
	
	public RestException(String message, String code, HttpStatus httpStatus, boolean isLogin) {
		super(message);
		this.code = code;
		this.httpStatus = httpStatus;
		this.isLogin = isLogin;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}  
}