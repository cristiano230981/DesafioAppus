package vbsolutions.com.br.DesafioAppus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vbsolutions.com.br.DesafioAppus.DesafioAppusApplication;
import vbsolutions.com.br.DesafioAppus.entities.VendedorEntity;
import vbsolutions.com.br.DesafioAppus.exception.ResourceNotFoundException;
import vbsolutions.com.br.DesafioAppus.repositories.VendedorRepository;
import vbsolutions.com.br.DesafioAppus.services.VendedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Vendedor")
@RequestMapping("/api/v1")
public class VendedorController {

	private static final Logger logger = LoggerFactory.getLogger(DesafioAppusApplication.class);

	@Autowired
	private VendedorRepository repository;
	
	@Autowired
	private VendedorService service;
	
	@ApiOperation(value = "Recupera todos os vendedores")
	@GetMapping("/vendedor")
    public List<VendedorEntity> getAllVendedores() {
        logger.info("Listar todos os vendedores");
        return service.findAll(); //.repository.findAll();
    }
	
	@ApiOperation(value = "Recupera todos os vendedores por maior número de vendas")
	@GetMapping("/vendedor/pedidos")
    public List<VendedorEntity> getAllVendedoresPorNumeroDeVendas() {
        logger.info("Listar todos os vendedores por qtde de vendas");
        return (List<VendedorEntity>) service.findAllWithOrderCount();
    } 
	
	@ApiOperation(value = "Recupera todos os vendedores por valor de venda")
	@GetMapping("/vendedor/valor")
    public List<VendedorEntity> getAllVendedoresPorValorDeVenda() {
        logger.info("Listar todos os vendedores por valor de vendas");
        return (List<VendedorEntity>) service.findByOrderByTotalDesc();
    }

	@ApiOperation(value = "Recupera um vendedor por id")
    @GetMapping("/vendedor/{id}")
    public ResponseEntity<VendedorEntity> getVendedorPorId(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Recupera vendedor pelo ID");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o ID: " + vendedorId));
        return ResponseEntity.ok().body(result);
    }
    
	@ApiOperation(value = "Recupera um vendedor por matrícula")
    @GetMapping("/vendedor/{matricula}")
    public ResponseEntity<VendedorEntity> getVendedorPorMatriculaId(@PathVariable(value = "matricula") String matricula) throws ResourceNotFoundException {
        logger.info("Recupera vendedor pela Matrícula");
        VendedorEntity result = repository.findByMatricula(matricula).
        		orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com a Matricula: " + matricula));
                
        return ResponseEntity.ok().body(result);
    }

	@ApiOperation(value = "Insere um vendedor")
    @PostMapping("/vendedor")
    public VendedorEntity insertVendedor(@Valid @RequestBody VendedorEntity value) {
        logger.info("Cadastrando vendedor...");
        return repository.save(value);
    }

	@ApiOperation(value = "Atualiza um vendedor")
    @PutMapping("/vendedor/{id}")
    public ResponseEntity<VendedorEntity> updateVendedor(@PathVariable(value = "id") long vendedorId, @RequestBody VendedorEntity updatedVendedor) throws ResourceNotFoundException {
        logger.info("Atualizando registro de vendedor...");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:: " + vendedorId));
        
        result.setNome(updatedVendedor.getNome());
        result.setMatricula(updatedVendedor.getMatricula());
        
        repository.save(result);
        return ResponseEntity.ok().body(result);

    }

	@ApiOperation(value = "Exclui um vendedor")
    @DeleteMapping("/vendedor/{id}")
    public void deleteVendedor(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Excluindo vendedor...");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o Id: " + vendedorId));
        repository.delete(result);
    }
	
}
