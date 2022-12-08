package mercadona.springbootapp.dto;

public class LoginForm {
	
	/** user */
	private String user;
	
	/** pass */
	private String pass;

	public LoginForm() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
