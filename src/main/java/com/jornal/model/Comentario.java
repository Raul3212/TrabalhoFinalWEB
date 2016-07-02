package com.jornal.model;

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
	private long id;
	
	@Column(nullable = false)
	private String texto;

	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "usuario_id", updatable = false, insertable = false)
	private long usuarioId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "noticia_id")
	private Noticia noticia;
	
	@Column(name = "noticia_id", updatable = false, insertable = false)
	private long noticiaId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public long getUsuarioId() {
		return usuarioId;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(long noticiaId) {
		this.noticiaId = noticiaId;
	}
	
}
