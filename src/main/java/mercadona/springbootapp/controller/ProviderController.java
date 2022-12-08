package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IProviderController;
import mercadona.springbootapp.dto.AllProviderResponse;
import mercadona.springbootapp.dto.ProviderDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IProviderService;

@RestController
@RequestMapping("/proveedor")
public class ProviderController implements IProviderController {

private static Log log = LogFactory.getLog(ProviderController.class);
	
	@Autowired
	IProviderService proveedorService;
    
	/**
	 * Método para obtener All Proveedores
	 * 
	 * @return code ResponseEntity<AllProveedorResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllProviderResponse> getAllProvider(String token) throws RestException {
    	
    	log.info("Access to AllProviders controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllProviderResponse> response = null;
		
		try {
			
			final AllProviderResponse res = proveedorService.getAllProvider();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllProviders");
				throw new RestException("No se ha podido encontrar Proveedores", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllProviders");
			throw new RestException("No se ha podido encontrar Proveedores", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to AllProviders() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener ProviderDTO  by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<ProviderDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<ProviderDTO> getProviderByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getProviderByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProviderDTO> response = null;
		
		try {
			
			final ProviderDTO res = proveedorService.getProviderByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getProviderByCod");
				throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getProviderByCod");
			throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getProviderByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Proveedor
	 * 
	 * @param ProviderDTO the proveedor to create
	 * @return code ResponseEntity<ProveedorDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<ProviderDTO> createProvider(String token, ProviderDTO request) throws RestException {
    	
    	log.info("Access to createProvider controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<ProviderDTO> response = null;
		
		try {
			
			final ProviderDTO res = proveedorService.createProvider(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido crear correctamente los datos del servicio REST createProvider");
				throw new RestException("No se ha podido crear Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido crear correctamente los datos del servicio REST createProvider");
			throw new RestException("No se ha podido crear Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createProvider(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Proveedor
   	 * 
   	 * @param ProviderDTO the proveedor to create
   	 * @return code ResponseEntity<ProveedorDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<ProviderDTO> updateProvider(String token, ProviderDTO request) throws RestException {
       	
       	log.info("Access to updateProvider controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<ProviderDTO> response = null;
   		
   		try {
   			
   			final ProviderDTO res = proveedorService.updateProvider(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProvider");
   				throw new RestException("No se ha podido actualizar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateProveedor");
   			throw new RestException("No se ha podido encontrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateProvider(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Proveedor
      	 * 
      	 * @param ProviderDTO the proveedor to create
      	 * @return code ResponseEntity<ProveedorDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<ProviderDTO> deleteProvider(String token, ProviderDTO request) throws RestException {
          	
          	log.info("Access to deleteProvider controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<ProviderDTO> response = null;
      		
      		try {
      			
      			final ProviderDTO res = proveedorService.deleteProvider(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProvider");
      				throw new RestException("No se ha podido borrar Proveedor para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteProvider");
      			throw new RestException("No se ha podido borrar Proveedor para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteProvider(" + request.getCod() + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }


}
