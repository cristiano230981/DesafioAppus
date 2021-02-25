package vbsolutions.com.br.DesafioAppus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "produtoid")
    private long produtoid;
    
    @Column(name = "qtde")
    private long qtde;
    
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

	public long getProdutoId() {
		return produtoid;
	}

	public void setProdutoId(long produtoid) {
		this.produtoid = produtoid;
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
}
