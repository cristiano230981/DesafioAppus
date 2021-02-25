package vbsolutions.com.br.DesafioAppus.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vbsolutions.com.br.DesafioAppus.entities.VendedorEntity;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Long> {
	
	Optional<VendedorEntity> findByMatricula(String matricula);

	@Query(
	        value = "SELECT p FROM VendedorEntity p JOIN p.pedidos ad GROUP BY p ORDER BY p.pedidos.size DESC",
	        countQuery = "SELECT COUNT(p) FROM VendedorEntity p"
	)
	Collection<VendedorEntity> findAllWithOrderCount();
	
	@Query(
	        value = "SELECT p FROM VendedorEntity p JOIN p.pedidos ad GROUP BY p ORDER BY MAX(ad.total) DESC",
	        countQuery = "SELECT COUNT(p) FROM VendedorEntity p"
	)
	Collection<VendedorEntity> findAllWithOrderValue();

	
}