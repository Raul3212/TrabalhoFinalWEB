package com.jornal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String texto;

	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "usuario_id", updatable = false, insertable = false)
	private Long usuarioId;
	
	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "noticia_id")
	private Noticia noticia;
	
	@Column(name = "noticia_id", updatable = false, insertable = false)
	private Long noticiaId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}
	
}
