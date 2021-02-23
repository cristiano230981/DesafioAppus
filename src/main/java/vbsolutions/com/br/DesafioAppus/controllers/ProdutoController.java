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
import vbsolutions.com.br.DesafioAppus.entities.ProdutoEntity;
import vbsolutions.com.br.DesafioAppus.exception.ResourceNotFoundException;
import vbsolutions.com.br.DesafioAppus.repositories.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Produto")
@RequestMapping("/api/v1")
public class ProdutoController {

	private static final Logger logger = LoggerFactory.getLogger(DesafioAppusApplication.class);

	@Autowired
	private ProdutoRepository repository;
	
	@ApiOperation(value = "Recupera todos os produtos")
	@GetMapping("/produto")
    public List<ProdutoEntity> getAllEmployees() {
        logger.info("Listar todos os vendedores");
        return repository.findAll();
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoEntity> getVendedorById(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Recupera vendedor pelo ID");
        ProdutoEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o ID: " + vendedorId));
        return ResponseEntity.ok().body(result);
    }
    

    @PostMapping("/produto")
    public ProdutoEntity add(@Valid @RequestBody ProdutoEntity value) {
        logger.info("Cadastrando vendedor...");
        return repository.save(value);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<ProdutoEntity> EmployeeById(@PathVariable(value = "id") long vendedorId, @RequestBody ProdutoEntity updatedVendedor) throws ResourceNotFoundException {
        logger.info("Atualizando registro de vendedor...");
        ProdutoEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:: " + vendedorId));
        
        result.setNome(updatedVendedor.getNome());
        result.setPreco(updatedVendedor.getPreco());
        
        repository.save(result);
        return ResponseEntity.ok().body(result);

    }

    @DeleteMapping("/produto/{id}")
    public void deleteEmployee(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Excluindo vendedor...");
        ProdutoEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o Id: " + vendedorId));
        repository.delete(result);
    }
	
}
