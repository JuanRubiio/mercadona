package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IDestinyController;
import mercadona.springbootapp.dto.AllDestinyResponse;
import mercadona.springbootapp.dto.DestinyDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IDestinyService;

@RestController
@RequestMapping("/destiny")
public class DestinyController implements IDestinyController {
	
	private static Log log = LogFactory.getLog(DestinyController.class);
	
	@Autowired
	IDestinyService destinoService;
    
	/**
	 * Método para obtener All Destiny
	 * 
	 * @return code ResponseEntity<AllDestinoResponse>
	 * @throws RestException 
	 */
    public ResponseEntity<AllDestinyResponse> getAllDestiny(String token) throws RestException {
    	
    	log.info("Access to AllDestiny controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<AllDestinyResponse> response = null;
		
		try {
			
			final AllDestinyResponse res = destinoService.getAllDestiny();
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST AllDestiny");
				throw new RestException("No se ha podido encontrar Destinos", "500", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST AllDestiny");
			throw new RestException("No se ha podido encontrar Destinos", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getAllDestiny() took "
				+ duration + " ms.");
		return response;
		
  }
    
	/**
	 * Método para obtener DestinyDTO  by codigo
	 * 
	 * @param cod the cod
	 * @return code ResponseEntity<DestinyDTO>
	 * @throws RestException 
	 */
    public ResponseEntity<DestinyDTO> getDestinyByCod(String token, Integer cod) throws RestException {
    	
    	log.info("Access to getDestinyByCod controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<DestinyDTO> response = null;
		
		try {
			
			final DestinyDTO res = destinoService.getDestinyByCod(cod);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST getDestinyByCod");
				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST getDestinyByCod");
			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getDestinyByCod(" + cod + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
	 * Método para crear entidad Destino
	 * 
	 * @param DestinyDTO the destino to create
	 * @return code ResponseEntity<DestinoDTO>
	 * @throws RestException 
	 */
    @Override
    public ResponseEntity<DestinyDTO> createDestiny(String token, DestinyDTO request) throws RestException {
    	
    	log.info("Access to createDestiny controller");
      
    	long startTime = System.nanoTime();
      
		ResponseEntity<DestinyDTO> response = null;
		
		try {
			
			final DestinyDTO res = destinoService.createDestiny(request);
			
			if (res != null) {
				response = ResponseEntity.ok(res);
				
			} else {
				log.error("No se ha podido obtener correctamente los datos del servicio REST createDestiny");
				throw new RestException("No se ha podido crear Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			
			log.error("No se ha podido obtener correctamente los datos del servicio REST createDestino");
			throw new RestException("No se ha podido crear Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to createDestiny(" + ") took "
				+ duration + " ms.");
		return response;
		
  }
    
    /**
   	 * Método para actualizar una entidad Destino
   	 * 
   	 * @param DestinyDTO the destino to create
   	 * @return code ResponseEntity<DestinoDTO>
   	 * @throws RestException 
   	 */
       @Override
       public ResponseEntity<DestinyDTO> updateDestiny(String token, DestinyDTO request) throws RestException {
       	
       	log.info("Access to updateDestino controller");
         
       	long startTime = System.nanoTime();
         
   		ResponseEntity<DestinyDTO> response = null;
   		
   		try {
   			
   			final DestinyDTO res = destinoService.updateDestiny(request);
   			
   			if (res != null) {
   				response = ResponseEntity.ok(res);
   				
   			} else {
   				log.error("No se ha podido obtener correctamente los datos del servicio REST updateDestiny");
   				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
   			}
   			
   		} catch (Exception e) {
   			
   			log.error("No se ha podido actualizar correctamente los datos del servicio REST updateDestiny");
   			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   		
   		long endTime = System.nanoTime();
   		long duration = (endTime - startTime) / 1000000L;
   		
   		log.info("The request to updateDestiny(" + ") took "
   				+ duration + " ms.");
   		return response;
   		
     }
       
       /**
      	 * Método para borrar una entidad Destino
      	 * 
      	 * @param DestinyDTO the destino to create
      	 * @return code ResponseEntity<DestinoDTO>
      	 * @throws RestException 
      	 */
          @Override
          public ResponseEntity<DestinyDTO> deleteDestiny(String token, DestinyDTO request) throws RestException {
          	
          	log.info("Access to deleteDestiny controller");
            
          	long startTime = System.nanoTime();
            
      		ResponseEntity<DestinyDTO> response = null;
      		
      		try {
      			
      			final DestinyDTO res = destinoService.deleteDestiny(request);
      			
      			if (res != null) {
      				response = ResponseEntity.ok(res);
      				
      			} else {
      				log.error("No se ha podido borrar correctamente los datos del servicio REST deleteDestiny");
      				throw new RestException("No se ha podido encontrar Destino para el valor indicado", "404", HttpStatus.NOT_FOUND);
      			}
      			
      		} catch (Exception e) {
      			
      			log.error("No se ha podido borrar correctamente los datos del servicio REST deleteDestiny");
      			throw new RestException("No se ha podido encontrar Destino para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
      		}
      		
      		long endTime = System.nanoTime();
      		long duration = (endTime - startTime) / 1000000L;
      		
      		log.info("The request to deleteDestiny(" + ") took "
      				+ duration + " ms.");
      		return response;
      		
        }


}
