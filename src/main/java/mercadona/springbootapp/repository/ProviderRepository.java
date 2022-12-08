package mercadona.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mercadona.springbootapp.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long>{

		List<Provider> findByCod (Integer cod);

}
