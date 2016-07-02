package com.jornal.model;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "noticia")
public class Noticia{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String subtitulo;
	
	@Column(nullable = false)
	private String texto;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "usuario_id", updatable = false, insertable = false)
	private long usuarioId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "secao_id")
	private Secao secao = null;
	
	@OneToMany(mappedBy = "noticia", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Collection<Comentario> comentarios;
	
	@Column(name = "secao_id", updatable = false, insertable = false)
	private long secaoId;
	
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

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(long secaoId) {
		this.secaoId = secaoId;
	}
	
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Noticia){
			Noticia noticia = (Noticia)obj;
			if(this.id == noticia.id)
				return true;
		}
		return false;
	}
	
}
