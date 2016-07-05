package com.jornal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.omg.CORBA.OMGVMCID;

@Entity(name = "secao")
public class Secao{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "secao", 
			cascade = CascadeType.REMOVE,
			fetch = FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Secao){
			Secao s = (Secao)obj;
			if(s.id == this.id){
				return true;
			}
		}
		return false;
	}
	
}
