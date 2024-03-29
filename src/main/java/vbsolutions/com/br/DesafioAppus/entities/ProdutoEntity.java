package vbsolutions.com.br.DesafioAppus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;
    
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "pedido",
//            joinColumns = @JoinColumn(
//                    name = "produto_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "id", referencedColumnName = "id"))
//    private Collection<PedidoEntity> pedidos;

    public ProdutoEntity() {
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
//	public Collection<PedidoEntity> getPedidos() {
//		return pedidos;
//	}
    
    
}
