package mercadona.springbootapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mercadona.springbootapp.dto.AllProviderResponse;
import mercadona.springbootapp.dto.ProviderDTO;
import mercadona.springbootapp.entity.Provider;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.ProviderRepository;
import mercadona.springbootapp.service.interfaces.IProviderService;
import mercadona.springbootapp.utils.Converters;

@Service
public class ProveedorService implements IProviderService{

	/** The log */
	private static Log log = LogFactory.getLog(ProveedorService.class);
	
	@Autowired
	private ProviderRepository proveedorRepo;
	
	@Override
	public AllProviderResponse getAllProvider() throws IOException, RestException {
		
		log.info("Access to getAllProveedor Service");
		AllProviderResponse res = new AllProviderResponse();
		
		List<Provider> listEntity = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			listEntity = proveedorRepo.findAll();
			
			List<ProviderDTO> listDto = new ArrayList<>();
			
			if ( listEntity.isEmpty() ) {
				return null;
			} else {
				
				log.info("Convierte lista de entidades Proveedor obtenidas a lista de DTOs Proveedor a devolver por el servicio");
				
				List<Object> listaObj = Converters.lisObjectEntityToListObjectDTO(listEntity, ProviderDTO.class);
				
				listDto = (List<ProviderDTO>)(Object) listaObj;
				
				res.setProviders(listDto);
				res.setNumProviders(listDto.size());
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Destino en BBDD", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public ProviderDTO getProviderByCod(Integer cod) throws IOException, RestException {
		
		log.info("Access to getProveedorByCod Service");
		ProviderDTO res = null;
		
		List<Provider> list = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			list = proveedorRepo.findByCod(cod);
			res = new ProviderDTO();
			
			if ( list.isEmpty() || list.get(0) ==  null) {
				return null;
			}else {
				res = (ProviderDTO) Converters.objectOrigenToObjectDestino(list.get(0), ProviderDTO.class);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Destino en BBDD para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public ProviderDTO createProvider(ProviderDTO proveedor) throws RestException {
		
		log.info("Access to createProveedor Service");
		ProviderDTO res = null;
		
		try {
			log.info("Convierte objeto proveedor dto a entity");
			Provider proveedorEntity = (Provider) Converters.objectOrigenToObjectDestino(proveedor, Provider.class);
			
			log.info("Llamada al repository para crear objeto en Base de Datos");
			List<Provider> entity = proveedorRepo.findByCod(proveedor.getCod());
			
			if ( entity.isEmpty() ||entity.get(0) == null ) {
				log.info("Llamada al repository para crear objeto en Base de Datos");
				Provider entitySaved = proveedorRepo.save(proveedorEntity);
				res = (ProviderDTO) Converters.objectOrigenToObjectDestino(entitySaved, ProviderDTO.class);
			} else {
				log.info("No se ha podido crear correctamente datos en BBDD, codigo existente");
				throw new RestException("No se ha podido crear Proveedor en BBDD, codigo ya existente", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido crear correctamente datos en BBDD");
			throw new RestException("No se ha podido crear Proveedor en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public ProviderDTO updateProvider(ProviderDTO proveedor) throws RestException {
		
		log.info("Access to updateProveedor Service");
		ProviderDTO res = null;
		
		try {
			log.info("Convierte objeto proveedor dto a entity");
			Provider proveedorEntity = (Provider) Converters.objectOrigenToObjectDestino(proveedor, Provider.class);
			
			log.info("Llamada al repository buscar objeto a actualizar");
			List<Provider> listaDest = new ArrayList<>();
			
			listaDest = proveedorRepo.findByCod(proveedor.getCod());
			
			Provider proveedorEnt = null;
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + proveedor.getCod() + "para actualizar");
				throw new RestException("No existen registro con el codigo indicado para actualizar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				log.info("Se obtiene el id del registro a actualizar");
				proveedorEntity.setId(listaDest.get(0).getId());
				
				log.info("Se actualiza el registro encontrado");
				proveedorEnt = proveedorRepo.save(proveedorEntity);
			}
			
			if ( proveedorEnt ==  null) {
				return null;
			}else {
				res = (ProviderDTO) Converters.objectOrigenToObjectDestino(proveedorEnt, ProviderDTO.class);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido actualizar correctamente datos en BBDD");
			throw new RestException("No se ha podido actualizar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public ProviderDTO deleteProvider(ProviderDTO proveedor) throws RestException {
		log.info("Access to deleteDestino Service");
		ProviderDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Provider proveedorEntity = (Provider) Converters.objectOrigenToObjectDestino(proveedor, Provider.class);
			
			log.info("Llamada al repository buscar objeto a borrar");
			List<Provider> listaDest = new ArrayList<>();
			
			listaDest = proveedorRepo.findByCod(proveedor.getCod());
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + proveedor.getCod() + "para borrar");
				throw new RestException("No existen registro con el codigo indicado para borrar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				log.info("Se obtiene el id del registro a borrar");
				proveedorEntity.setId(listaDest.get(0).getId());
				
				log.info("Se borra el registro encontrado");
				proveedorRepo.delete(proveedorEntity);
			}
			
			res = proveedor;
			
		} catch (Exception e) {
			log.info("No se ha podido borrar correctamente datos en BBDD");
			throw new RestException("No se ha podido borrar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
}
