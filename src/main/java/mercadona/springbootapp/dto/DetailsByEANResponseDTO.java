package mercadona.springbootapp.dto;

public class DetailsByEANResponseDTO {

	/** EAN */
	private String EAN;
	
	/** destiny */
	private DestinyDTO destiny;
	
	/** product */
	private ProductDTO product;
	
	/** provider */
	private ProviderDTO provider;

	public DetailsByEANResponseDTO() {
		super();
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public DestinyDTO getDestiny() {
		return destiny;
	}

	public void setDestiny(DestinyDTO destiny) {
		this.destiny = destiny;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public ProviderDTO getProvider() {
		return provider;
	}

	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}

}
