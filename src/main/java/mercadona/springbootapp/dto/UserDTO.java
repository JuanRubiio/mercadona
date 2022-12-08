package mercadona.springbootapp.dto;

public class UserDTO {

	/** username */
	private String username;
	
	/** password */
	private String password;
	
	public UserDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
