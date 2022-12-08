package mercadona.springbootapp.dto;

public class ProviderDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	/** email */
	private String email;
	
	public ProviderDTO() {
		super();
	}
	
	public Integer getCod() {
		return cod;
	}
	public String getName() {
		return name;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
