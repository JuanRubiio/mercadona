package mercadona.springbootapp.dto;

import java.util.List;

public class AllDestinyResponse {

	/** destinos */
	private List<DestinyDTO> destinos;
	
	/** numDestinos */
	private Integer numDestinos;

	public AllDestinyResponse() {
		super();
	}

	public List<DestinyDTO> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<DestinyDTO> destinos) {
		this.destinos = destinos;
	}

	public Integer getNumDestinos() {
		return numDestinos;
	}

	public void setNumDestinos(Integer numDestinos) {
		this.numDestinos = numDestinos;
	}
	
	
}
