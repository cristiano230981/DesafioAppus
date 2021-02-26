package vbsolutions.com.br.DesafioAppus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalhePedido")
public class PedidoDetalheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "qtde")
    private long qtde;
    
    @Column(name = "total")
    private float total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
    
    public PedidoDetalheEntity() {
        super();
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public long getQtde() {
		return qtde;
	}

	public void setQtde(long qtde) {
		this.qtde = qtde;
	}
	
    public float getTotal() {
		return total;
	}

	public void setQtde(float total) {
		this.total = total;
	}
	
    public PedidoEntity getPedido() {
		return pedido;
	}
    
//    public ProdutoEntity getProduto() {
//		return produto;
//	}
}
