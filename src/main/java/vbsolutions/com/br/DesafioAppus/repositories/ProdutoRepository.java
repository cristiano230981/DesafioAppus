package vbsolutions.com.br.DesafioAppus.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vbsolutions.com.br.DesafioAppus.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	//Optional<ProdutoEntity> findBySales();
}
