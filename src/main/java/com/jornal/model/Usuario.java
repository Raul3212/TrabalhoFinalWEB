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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	public static int LEITOR = 1;
	public static int JORNALISTA = 2;
	public static int EDITOR = 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false, updatable = false)
	private String senha;
	
	@Column(nullable = false)
	private int tipo;
	
	@OneToMany(mappedBy = "usuario", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.REMOVE,
			orphanRemoval = true)
	private Collection<Noticia> noticias;
	
	@OneToMany(mappedBy = "usuario",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.LAZY)
	private Collection<Comentario> comentarios;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Usuario){
			Usuario user = (Usuario)obj;
			return this.id == user.id;
		}
		return false;
	}
	
}
