package vbsolutions.com.br.DesafioAppus.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="pedido", fetch = FetchType.EAGER)
    private Collection<PedidoDetalheEntity> detalhe;
    
    @JsonBackReference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendedor_id")
    private VendedorEntity vendedor;
    
//    @Column(name = "qtde")
//    private long qtde;
//    
    @Column(name = "total")
    private float total;
    
    public PedidoEntity() {
        super();
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//    public long getQtde() {
//		return qtde;
//	}
//
//	public void setQtde(long qtde) {
//		this.qtde = qtde;
//	}
//	
    public float getTotal() {
		return total;
	}

	public void setQtde(float total) {
		this.total = total;
	}
	
    public Collection<PedidoDetalheEntity> getDetalhe() {
		return detalhe;
	}
    
//    public VendedorEntity getVendedor() {
//		return vendedor;
//	}
}
