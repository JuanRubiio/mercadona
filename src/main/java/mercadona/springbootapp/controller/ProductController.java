package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IProductController;
import mercadona.springbootapp.dto.AllProductResponse;
import mercadona.springbootapp.dto.ProductDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController implements IProductController{

private static Log log = LogFactory.getLog(ProductController.class);
	
	@Autowired
	IProductService productService;
    
	/**
	 * Método para obtener All Product
	 * 
	 * @return code ResponseEntity<AllProductResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllProductResponse> getAllProduct(String token) throws RestException {
    	
    	log.info("Access to AllProduct controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllProductResponse> response = null;
		
		try {
			
			final AllProductResponse res = productService.getAllProduct();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllProduct");
				throw new RestException("No se ha podido encontrar Productos", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllProduct");
			throw new RestException("No se ha podido encontrar Productos", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to AllProduct() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener ProductDTO by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<ProductDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<ProductDTO> getProductByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getProductByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProductDTO> response = null;
		
		try {
			
			final ProductDTO res = productService.getProductByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getProductByCod");
				throw new RestException("No se ha podido encontrar Product para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getProductByCod");
			throw new RestException("No se ha podido encontrar Product para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getProductByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Product
	 * 
	 * @param ProductDTO the Product to create
	 * @return code ResponseEntity<ProductDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<ProductDTO> createProduct(String token, ProductDTO request) throws RestException {
    	
    	log.info("Access to createProduct controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProductDTO> response = null;
		
		try {
			
			final ProductDTO res = productService.createProduct(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido crear correctamente los datos del servicio REST createProduct");
				throw new RestException("No se ha podido crear Product para el valor indicado", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido crear correctamente los datos del servicio REST createProduct");
			throw new RestException("No se ha podido crear Product para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createProduct(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Product
   	 * 
   	 * @param ProductDTO the Product to create
   	 * @return code ResponseEntity<ProductDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<ProductDTO> updateProduct(String token, ProductDTO request) throws RestException {
       	
       	log.info("Access to updateProduct controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<ProductDTO> response = null;
   		
   		try {
   			
   			final ProductDTO res = productService.updateProduct(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProduct");
   				throw new RestException("No se ha podido actualizar Product para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProduct");
   			throw new RestException("No se ha podido encontrar Product para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateProduct(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Product
      	 * 
      	 * @param ProductDTO the Product to create
      	 * @return code ResponseEntity<ProductDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<ProductDTO> deleteProduct(String token, ProductDTO request) throws RestException {
          	
          	log.info("Access to deleteProduct controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<ProductDTO> response = null;
      		
      		try {
      			
      			final ProductDTO res = productService.deleteProduct(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProduct");
      				throw new RestException("No se ha podido borrar Product para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProduct");
      			throw new RestException("No se ha podido borrar Product para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteProduct(" + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }

}
