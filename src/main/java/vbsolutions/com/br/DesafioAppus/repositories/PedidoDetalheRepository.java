package vbsolutions.com.br.DesafioAppus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vbsolutions.com.br.DesafioAppus.entities.PedidoDetalheEntity;

@Repository
public interface PedidoDetalheRepository extends JpaRepository<PedidoDetalheEntity, Long> {

}