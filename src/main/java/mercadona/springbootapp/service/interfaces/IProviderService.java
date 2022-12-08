package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllProviderResponse;
import mercadona.springbootapp.dto.ProviderDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProviderService {

	public ProviderDTO getProviderByCod (Integer cod) throws RestException, IOException;
	
	public ProviderDTO createProvider (ProviderDTO destino) throws RestException;
	
	public ProviderDTO updateProvider (ProviderDTO destino) throws RestException;
	
	public ProviderDTO deleteProvider (ProviderDTO destino) throws RestException;
	
	public AllProviderResponse getAllProvider () throws RestException, IOException;
}
