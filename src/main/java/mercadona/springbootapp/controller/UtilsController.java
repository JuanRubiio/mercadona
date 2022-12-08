package mercadona.springbootapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercadona.springbootapp.controller.interfaces.IUtilsController;
import mercadona.springbootapp.dto.DestinyDTO;
import mercadona.springbootapp.dto.DetailsByEANResponseDTO;
import mercadona.springbootapp.dto.ProductDTO;
import mercadona.springbootapp.dto.ProviderDTO;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.service.interfaces.IDestinyService;
import mercadona.springbootapp.service.interfaces.IProductService;
import mercadona.springbootapp.service.interfaces.IProviderService;
import mercadona.springbootapp.utils.Utilidades;

@RestController
@RequestMapping("/utils")
public class UtilsController implements IUtilsController {

private static Log log = LogFactory.getLog(UtilsController.class);

	@Autowired
	IProviderService providerService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IDestinyService destinyService;
	
	/**
	 * Método para obtener detalles by ean
	 * 
	 * @return code ResponseEntity<AllProveedorResponse>
	 * @throws RestException 
	 */
	@Override
	public ResponseEntity<DetailsByEANResponseDTO> getDetailsByEAN(String token, String ean) throws RestException {
		
		log.info("Access to getDetallesByEAN controller");
	  
		long startTime = System.nanoTime();
	  
		ResponseEntity<DetailsByEANResponseDTO> response = null;
		
		try {
			
			Boolean esNumeric = Utilidades.isNumeric(ean);
			
			if ( !esNumeric ) {
				log.error("El String dado no es válido, existen letras.");
				throw new RestException("El EAN dado no es válido, contiene letras.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			Integer numCaracteres = ean.length();
			
			if (numCaracteres!=13) {
				log.error("El String dado no es válido, debe tener una longitud exacta de 13 caracteres.");
				throw new RestException("El String dado no es válido, debe tener una longitud exacta de 13 caracteres.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
			final DetailsByEANResponseDTO res = new DetailsByEANResponseDTO();

			
			String destino = ean.substring(12);
			String proveedor = ean.substring(0, 7);
			String producto = ean.substring(7,12);
			
			ProductDTO productoDto = productService.getProductByCod(Integer.valueOf(producto));
			
			if( productoDto==null ) {
				log.error("No existe producto con codigo: " + producto + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe producto con codigo: " + producto + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setProduct(productoDto);
			}
			
			ProviderDTO proveedorDto = providerService.getProviderByCod(Integer.valueOf(proveedor));
			
			if( proveedorDto==null ) {
				log.error("No existe producto con codigo: " + proveedor + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe proveedor con codigo: " + proveedor + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setProvider(proveedorDto);
			}
			
			DestinyDTO destinoDto = destinyService.getDestinyByCod(Integer.valueOf(destino));
			
			if( destinoDto==null ) {
				log.error("No existe producto con codigo: " + destino + " por favor, compruebe el número EAN introducido.");
				throw new RestException("No existe destino con codigo: " + destino + " por favor, compruebe el número EAN introducido.", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			
			} else {
				res.setDestiny(destinoDto);
			}
			
			res.setEAN(ean);
			response = ResponseEntity.ok(res);
			
		} catch (Exception e) {
			
			log.error(e.getMessage());
			throw new RestException(e.getMessage(), "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000L;
		
		log.info("The request to getDetailsByEAN("+ean+") took "
				+ duration + " ms.");
		return response;
		
	}


}
