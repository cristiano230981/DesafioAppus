package vbsolutions.com.br.DesafioAppus.repositories;

import java.util.Collection;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vbsolutions.com.br.DesafioAppus.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	//Optional<ProdutoEntity> findBySales();
	@Query(
	        value = "SELECT p FROM ProdutoEntity p JOIN p.pedidos ad GROUP BY p ORDER BY p.pedidos.size DESC",
	        countQuery = "SELECT COUNT(p) FROM VendedorEntity p"
	)
	Collection<ProdutoEntity> findAllBestSelling();
}
