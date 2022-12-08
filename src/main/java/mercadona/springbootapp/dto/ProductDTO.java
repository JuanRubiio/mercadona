package mercadona.springbootapp.dto;

public class ProductDTO {

	/** cod */
	private Integer cod;
	
	/** name */
	private String name;
	
	/** description */
	private String description;
	
	public ProductDTO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
