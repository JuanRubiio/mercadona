package mercadona.springbootapp.dto;

public class DestinyDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	/** address */
	private String address;
	
	/** postalCode */
	private String postalCode;
	
	/** city */
	private String city;
	
	public DestinyDTO() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
