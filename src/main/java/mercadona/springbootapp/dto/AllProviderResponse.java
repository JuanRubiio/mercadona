package mercadona.springbootapp.dto;

import java.util.List;

public class AllProviderResponse {
	
	/** providers */
	private List<ProviderDTO> providers;
	
	/** numProviders */
	private Integer numProviders;

	public AllProviderResponse() {
		super();
	}

	public List<ProviderDTO> getProviders() {
		return providers;
	}

	public void setProviders(List<ProviderDTO> providers) {
		this.providers = providers;
	}

	public Integer getNumProviders() {
		return numProviders;
	}

	public void setNumProviders(Integer providers) {
		this.numProviders = providers;
	}

}
