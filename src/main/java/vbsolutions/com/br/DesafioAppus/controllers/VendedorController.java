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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VendedorController {

	private static final Logger logger = LoggerFactory.getLogger(DesafioAppusApplication.class);

	@Autowired
	private VendedorRepository repository;
	
	@GetMapping("/vendedor")
    public List<VendedorEntity> getAllEmployees() {
        logger.info("Listar todos os vendedores");
        return repository.findAll();
    }

    @GetMapping("/vendedor/{id}")
    public ResponseEntity<VendedorEntity> getVendedorById(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Recupera vendedor pelo ID");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o ID: " + vendedorId));
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/vendedor")
    public VendedorEntity add(@Valid @RequestBody VendedorEntity value) {
        logger.info("Cadastrando vendedor...");
        return repository.save(value);
    }

    @PutMapping("/vendedor/{id}")
    public ResponseEntity<VendedorEntity> EmployeeById(@PathVariable(value = "id") long vendedorId, @RequestBody VendedorEntity updatedVendedor) throws ResourceNotFoundException {
        logger.info("Atualizando registro de vendedor...");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:: " + vendedorId));
        
        result.setNome(updatedVendedor.getNome());
        result.setMatricula(updatedVendedor.getMatricula());
        
        repository.save(result);
        return ResponseEntity.ok().body(result);

    }

    @DeleteMapping("/vendedor/{id}")
    public void deleteEmployee(@PathVariable(value = "id") long vendedorId) throws ResourceNotFoundException {
        logger.info("Excluindo vendedor...");
        VendedorEntity result = repository.findById(vendedorId).
                orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com o Id: " + vendedorId));
        repository.delete(result);
    }
	
}
