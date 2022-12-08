package mercadona.springbootapp.service.interfaces;

import java.io.IOException;

import mercadona.springbootapp.dto.AllProductResponse;
import mercadona.springbootapp.dto.ProductDTO;
import mercadona.springbootapp.exception.RestException;

public interface IProductService {
	
	public ProductDTO getProductByCod (Integer cod) throws RestException, IOException;
	
	public ProductDTO createProduct (ProductDTO destino) throws RestException;
	
	public ProductDTO updateProduct (ProductDTO destino) throws RestException;
	
	public ProductDTO deleteProduct (ProductDTO destino) throws RestException;
	
	public AllProductResponse getAllProduct () throws RestException, IOException;
}
