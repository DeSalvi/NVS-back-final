package br.itb.projeto.newvision.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CampanhaProduto")
public class CampanhaProduto {
	
	@Id
	@GeneratedValue
		(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "campanha_id")
	private Campanha campanha;
	
	private String statusCampanhaProduto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public String getStatusCampanhaProduto() {
		return statusCampanhaProduto;
	}

	public void setStatusCampanhaProduto(String statusCampanhaProduto) {
		this.statusCampanhaProduto = statusCampanhaProduto;
	}
	
	

}
