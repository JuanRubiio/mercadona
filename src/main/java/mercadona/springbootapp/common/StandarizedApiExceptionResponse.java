package mercadona.springbootapp.common;

public class StandarizedApiExceptionResponse{
    private String code;
    private String message;

    public StandarizedApiExceptionResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
       
    public StandarizedApiExceptionResponse() {
		super();
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}