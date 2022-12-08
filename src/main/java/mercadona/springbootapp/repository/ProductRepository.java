package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCod (Integer cod);

}
