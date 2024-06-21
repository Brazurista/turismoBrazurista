package br.itb.projeto.turismo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roteiro")
public class Roteiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private LocalDateTime dataCriado;
	private String StatusRoteiro;
	private String usuarioId;
	private String tipoRoteiroId;
	private String categoriaId;

	@ManyToOne
	@JoinColumn(name = "usuarioId", insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "tipoRoteiroId", insertable = false, updatable = false)
	private TipoRoteiro tipoRoteiro;

	@ManyToOne
	@JoinColumn(name = "categoriaId", insertable = false, updatable = false)
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(LocalDateTime dataCriado) {
		this.dataCriado = dataCriado;
	}

	public String getStatusRoteiro() {
		return StatusRoteiro;
	}

	public void setStatusRoteiro(String statusRoteiro) {
		this.StatusRoteiro = statusRoteiro;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getTipoRoteiroId() {
		return tipoRoteiroId;
	}

	public void setTipoRoteiroId(String tipoRoteiroId) {
		this.tipoRoteiroId = tipoRoteiroId;
	}

	public String getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(String categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoRoteiro getTipoRoteiro() {
		return tipoRoteiro;
	}

	public void setTipoRoteiro(TipoRoteiro tipoRoteiro) {
		this.tipoRoteiro = tipoRoteiro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
