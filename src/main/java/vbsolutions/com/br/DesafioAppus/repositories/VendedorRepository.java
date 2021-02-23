package vbsolutions.com.br.DesafioAppus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vbsolutions.com.br.DesafioAppus.entities.VendedorEntity;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Long> {
	//@Query("select u from vendedor u where u.matricula like %?1")
	Optional<VendedorEntity> findByMatricula(String matricula);
	
	//@Query("select u from vendedor u where u.matricula like %?1")
	List<VendedorEntity> findByNumberOfSales();
	
	//@Query("select u from vendedor u where u.matricula like %?1")
	List<VendedorEntity> findByValueOfSales();
}