package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllDestinyResponse;
import mercadona.springbootapp.dto.DestinyDTO;
import mercadona.springbootapp.exception.RestException;

public interface IDestinyService {
	
	public DestinyDTO getDestinyByCod (Integer cod) throws RestException, IOException;
	
	public DestinyDTO createDestiny (DestinyDTO destino) throws RestException;
	
	public DestinyDTO updateDestiny (DestinyDTO destino) throws RestException;
	
	public DestinyDTO deleteDestiny (DestinyDTO destino) throws RestException;
	
	public AllDestinyResponse getAllDestiny () throws RestException, IOException;
	
}
