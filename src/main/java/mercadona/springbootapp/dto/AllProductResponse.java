package mercadona.springbootapp.dto;

import java.util.List;

public class AllProductResponse {

	/** productos */
	private List<ProductDTO> productos;
	
	/** numProductos */
	private Integer numProductos;

	public AllProductResponse() {
		super();
	}

	public List<ProductDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductDTO> productos) {
		this.productos = productos;
	}

	public Integer getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(Integer numProductos) {
		this.numProductos = numProductos;
	}

}
