package mercadona.springbootapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mercadona.springbootapp.dto.AllProductResponse;
import mercadona.springbootapp.dto.ProductDTO;
import mercadona.springbootapp.entity.Product;
import mercadona.springbootapp.exception.RestException;
import mercadona.springbootapp.repository.ProductRepository;
import mercadona.springbootapp.service.interfaces.IProductService;
import mercadona.springbootapp.utils.Converters;

@Service
public class ProductService implements IProductService{

	/** The log */
	private static Log log = LogFactory.getLog(ProductService.class);
	
	@Autowired
	private ProductRepository productoRepo;
	
	@Override
	public AllProductResponse getAllProduct() throws IOException, RestException {
		
		log.info("Access to getAllProducto Service");
		AllProductResponse res = new AllProductResponse();
		
		List<Product> listEntity = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			listEntity = productoRepo.findAll();
			
			List<ProductDTO> listDto = new ArrayList<>();
			
			if ( listEntity.isEmpty() ) {
				return null;
			} else {
				
				log.info("Convierte lista de entidades Producto obtenidas a lista de DTOs Producto a devolver por el servicio");
				
				List<Object> listaObj = Converters.lisObjectEntityToListObjectDTO(listEntity, ProductDTO.class);
				
				listDto = (List<ProductDTO>)(Object) listaObj;
				
				res.setProductos(listDto);
				res.setNumProductos(listDto.size());
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Producto en BBDD", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public ProductDTO getProductByCod(Integer cod) throws IOException, RestException {
		
		log.info("Access to getProductoByCod Service");
		ProductDTO res = null;
		
		List<Product> list = new ArrayList<>();
		
		log.info("Llamada al repository para obtener datos de Base de Datos");
		
		try {
			list = productoRepo.findByCod(cod);
			res = new ProductDTO();
			
			if ( list.isEmpty() || list.get(0) ==  null) {
				return null;
			}else {
				res = (ProductDTO) Converters.objectOrigenToObjectDestino(list.get(0), ProductDTO.class);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido obtener correctamente datos de BBDD");
			throw new RestException("No se ha podido encontrar Producto en BBDD para el valor indicado", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public ProductDTO createProduct(ProductDTO producto) throws RestException {
		
		log.info("Access to createProducto Service");
		ProductDTO res = null;
		
		try {
			log.info("Convierte objeto Producto dto a entity");
			Product ProductoEntity = (Product) Converters.objectOrigenToObjectDestino(producto, Product.class);
			
			log.info("Llamada al repository para crear objeto en Base de Datos");
			List<Product> entity = productoRepo.findByCod(producto.getCod());
			
			if ( entity.isEmpty() ||entity.get(0) == null ) {
				log.info("Llamada al repository para crear objeto en Base de Datos");
				Product entitySaved = productoRepo.save(ProductoEntity);
				res = (ProductDTO) Converters.objectOrigenToObjectDestino(entitySaved, ProductDTO.class);
			} else {
				log.info("No se ha podido crear correctamente datos en BBDD, codigo existente");
				throw new RestException("No se ha podido crear Producto en BBDD, codigo ya existente", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido crear correctamente datos en BBDD");
			throw new RestException("No se ha podido crear Producto en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
	
	@Override
	public ProductDTO updateProduct(ProductDTO producto) throws RestException {
		
		log.info("Access to updateProducto Service");
		ProductDTO res = null;
		
		try {
			log.info("Convierte objeto Producto dto a entity");
			Product ProductoEntity = (Product) Converters.objectOrigenToObjectDestino(producto, Product.class);
			
			log.info("Llamada al repository buscar objeto a actualizar");
			List<Product> listaDest = new ArrayList<>();
			
			listaDest = productoRepo.findByCod(producto.getCod());
			
			Product ProductoEnt = null;
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + producto.getCod() + "para actualizar");
				throw new RestException("No existen registro con el codigo indicado para actualizar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				
				log.info("Se obtiene el id del registro a actualizar");
				ProductoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se actualiza el registro encontrado");
				ProductoEnt = productoRepo.save(ProductoEntity);
			}
			
			if ( ProductoEnt ==  null) {
				return null;
			}else {
				res = (ProductDTO) Converters.objectOrigenToObjectDestino(ProductoEnt, ProductDTO.class);
			}
			
		} catch (Exception e) {
			log.info("No se ha podido actualizar correctamente datos en BBDD");
			throw new RestException("No se ha podido actualizar Producto en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}

	@Override
	public ProductDTO deleteProduct(ProductDTO producto) throws RestException {
		log.info("Access to deleteProducto Service");
		ProductDTO res = null;
		
		try {
			log.info("Convierte objeto producto dto a entity");
			Product ProductoEntity = (Product) Converters.objectOrigenToObjectDestino(producto, Product.class);
			
			log.info("Llamada al repository buscar objeto a borrar");
			List<Product> listaDest = new ArrayList<>();
			
			listaDest = productoRepo.findByCod(producto.getCod());
			
			if (listaDest.isEmpty() || listaDest.get(0)==null) {
				log.info("No existen registro con cod: " + producto.getCod() + "para borrar");
				throw new RestException("No existen registro con el codigo indicado para borrar", "500", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				log.info("Se obtiene el id del registro a borrar");
				ProductoEntity.setId(listaDest.get(0).getId());
				
				log.info("Se borra el registro encontrado");
				productoRepo.delete(ProductoEntity);
			}
			
			res = producto;
			
		} catch (Exception e) {
			log.info("No se ha podido borrar correctamente datos en BBDD");
			throw new RestException("No se ha podido borrar Producto en BBDD para los valores indicados", "500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return res;
	}
}
