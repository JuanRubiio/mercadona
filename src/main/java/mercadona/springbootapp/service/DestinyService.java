package mercadona.springbootapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mercadona.springbootapp.dto.AllDestinyResponse;
import mercadona.springbootapp.dto.DestinyDTO;
import mercadona.springbootapp.entity.Destiny;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.DestinyRepository;
import mercadona.springbootapp.service.interfaces.IDestinyService;
import mercadona.springbootapp.utils.Converters;

@Service
public class DestinyService implements IDestinyService{

	/** The log */
	private static Log log = LogFactory.getLog(DestinyService.class);
	
	@Autowired
	private DestinyRepository destinoRepo;
	
	@Override
	public AllDestinyResponse getAllDestiny() throws IOException, RestException {
		
		log.info("Access to getAllDestino Service");
		AllDestinyResponse res = new AllDestinyResponse();
		
		List<Destiny> listEntity = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			listEntity = destinoRepo.findAll();
			
			List<DestinyDTO> listDto = new ArrayList<>();
			
			if ( listEntity.isEmpty() ) {
				return null;
			} else {
				
				log.info("Convierte lista de entidades Destino obtenidas a lista de DTOs Destino a devolver por el servicio");
				
				List<Object> listaObj = Converters.lisObjectEntityToListObjectDTO(listEntity, DestinyDTO.class);
						
				listDto = (List<DestinyDTO>)(Object) listaObj;
				
				res.setDestinos(listDto);
				res.setNumDestinos(listDto.size());
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Destino en BBDD", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public DestinyDTO getDestinyByCod(Integer cod) throws IOException, RestException {
		
		log.info("Access to getDestinoByCod Service");
		DestinyDTO res = null;
		
		List<Destiny> list = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			list = destinoRepo.findByCod(cod);
			res = new DestinyDTO();
			
			if ( list.isEmpty() || list.get(0) ==  null) {
				return null;
			}else {
				res = (DestinyDTO) Converters.objectOrigenToObjectDestino(list.get(0), DestinyDTO.class);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Destino en BBDD para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public DestinyDTO createDestiny(DestinyDTO destino) throws RestException {
		
		log.info("Access to createDestino Service");
		DestinyDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destiny destinoEntity = (Destiny) Converters.objectOrigenToObjectDestino(destino, Destiny.class);
			
			log.info("Comprueba si existe ya un objeto con el codigo indicado");
			List<Destiny> entity = destinoRepo.findByCod(destino.getCod());
			
			if (entity.isEmpty() ||entity.get(0) == null ) {
				log.info("Llamada al repository para crear objeto en Base de Datos");
				Destiny entitySaved = destinoRepo.save(destinoEntity);
				res = (DestinyDTO) Converters.objectOrigenToObjectDestino(entitySaved, DestinyDTO.class);
			} else {
				log.info("No se ha podido crear correctamente datos en BBDD, codigo existente");
				throw new RestException("No se ha podido crear Destino en BBDD, codigo ya existente", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido crear correctamente datos en BBDD");
			throw new RestException("No se ha podido crear Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public DestinyDTO updateDestiny(DestinyDTO destino) throws RestException {
		
		log.info("Access to updateDestino Service");
		DestinyDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destiny destinoEntity = (Destiny) Converters.objectOrigenToObjectDestino(destino, Destiny.class);
			
			log.info("Llamada al repository buscar objeto a actualizar");
			List<Destiny> listaDest = new ArrayList<>();
			
			listaDest = destinoRepo.findByCod(destino.getCod());
			
			Destiny destinoEnt = null;
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + destino.getCod() + "para actualizar");
				throw new RestException("No existen registro con el codigo indicado para actualizar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				log.info("Se obtiene el id del registro a actualizar");
				destinoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se actualiza el registro encontrado");
				destinoEnt = destinoRepo.save(destinoEntity);
			}
			
			if ( destinoEnt ==  null) {
				return null;
			}else {
				res = (DestinyDTO) Converters.objectOrigenToObjectDestino(destinoEnt, DestinyDTO.class );
			}
			
		} catch (Exception e) {
			log.info("No se ha podido actualizar correctamente datos en BBDD");
			throw new RestException("No se ha podido actualizar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public DestinyDTO deleteDestiny(DestinyDTO destino) throws RestException {
		log.info("Access to deleteDestino Service");
		DestinyDTO res = null;
		
		try {
			log.info("Convierte objeto destino dto a entity");
			Destiny destinoEntity = (Destiny) Converters.objectOrigenToObjectDestino(destino, Destiny.class);
			
			log.info("Llamada al repository buscar objeto a borrar");
			List<Destiny> listaDest = new ArrayList<>();
			
			listaDest = destinoRepo.findByCod(destino.getCod());
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + destino.getCod() + "para borrar");
				throw new RestException("No existen registro con el codigo indicado para borrar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				log.info("Se obtiene el id del registro a borrar");
				destinoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se borra el registro encontrado");
				destinoRepo.delete(destinoEntity);
			}
			
			res = destino;
			
		} catch (Exception e) {
			log.info("No se ha podido borrar correctamente datos en BBDD");
			throw new RestException("No se ha podido borrar Destino en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	
}
