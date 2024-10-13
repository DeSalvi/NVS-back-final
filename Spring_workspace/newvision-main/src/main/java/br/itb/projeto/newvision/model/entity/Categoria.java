package br.itb.projeto.newvision.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue
		(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeCat;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCat() {
		return nomeCat;
	}
	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}
}
