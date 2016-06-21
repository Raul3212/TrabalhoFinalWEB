package com.jornal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "secao")
public class Secao {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "secao", 
			targetEntity = Noticia.class,
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<Noticia> noticias;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}
	
}
