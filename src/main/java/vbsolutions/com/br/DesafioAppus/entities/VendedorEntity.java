package vbsolutions.com.br.DesafioAppus.entities;

import java.util.Collection;

import javax.persistence.CascadeType;

//import java.util.Collection;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vendedor")
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "pedido",
//            joinColumns = @JoinColumn(
//                    name = "vendedor_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "id", referencedColumnName = "id"))
//    private Collection<PedidoEntity> pedidos;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="vendedor")
//    private Collection<PedidoEntity> pedidos;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="vendedor", fetch = FetchType.EAGER)
    private Collection<PedidoEntity> pedidos;
    
    public VendedorEntity() {
        super();
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Collection<PedidoEntity> getPedidos() {
		return pedidos;
	}
    
    
}
