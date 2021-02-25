package vbsolutions.com.br.DesafioAppus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vbsolutions.com.br.DesafioAppus.entities.VendedorEntity;
import vbsolutions.com.br.DesafioAppus.repositories.VendedorRepository;

import java.util.Collection;
import java.util.List;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository repository;
    
    public List<VendedorEntity> findAll(){
    	return repository.findAll();
    }
    
    public Collection<VendedorEntity> findAllWithOrderCount(){
    	return repository.findAllWithOrderCount();
    }
    
    public Collection<VendedorEntity> findByOrderByTotalDesc(){
    	
    	return repository.findAllWithOrderValue();
    }
    
}
