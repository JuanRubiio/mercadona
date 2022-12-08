package mercadona.springbootapp.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class Converters {

	private static Log log = LogFactory.getLog(Converters.class);
	
	public static ModelMapper modelMapper = new ModelMapper();
	
	public static List<Object> lisObjectEntityToListObjectDTO(List<?> listEnt, Object obDestino) {
		
		log.info("Convertir lista de objeto entidad a lista de objecto dto");
		
		List<Object> res = new ArrayList<>();
		
		res = modelMapper.map(listEnt,new TypeToken<List<Object>>(){}.getType());
		
		return res;
	}
	
	public static <T> Object objectOrigenToObjectDestino(Object obOrigen, Class<T> obDestino) {
		
		log.info("Convertir objeto origen a objeto destino");
		
		Object res = modelMapper.map(obOrigen, obDestino);
		
		return res;
	}
	
}
