package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Destiny;

public interface DestinyRepository extends JpaRepository<Destiny, Long>{
	
	List<Destiny> findByCod (Integer cod);

}
