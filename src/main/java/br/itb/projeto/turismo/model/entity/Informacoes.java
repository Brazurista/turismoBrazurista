package br.itb.projeto.turismo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Informacoes")
public class Informacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;

	// usado para as chaves estrangeiras
	// repetir sempre que tiver uma
	@ManyToOne
	@JoinColumn(name = "pontoInterId", insertable = false, updatable = false)
	private PontoInteresse pontoInteresse;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PontoInteresse getPontoInteresse() {
		return pontoInteresse;
	}

	public void setPontoInteresse(PontoInteresse pontoInteresse) {
		this.pontoInteresse = pontoInteresse;
	}

}
