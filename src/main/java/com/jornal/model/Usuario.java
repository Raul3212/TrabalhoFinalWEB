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

@Entity(name = "usuario")
public class Usuario {
	
	public static int LEITOR = 1;
	public static int JORNALISTA = 2;
	public static int EDITOR = 3;
	
	@Id
	@Column(nullable = false)
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
			targetEntity = Noticia.class,
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<Noticia> noticias;
	
	@OneToMany(mappedBy = "usuario",
			targetEntity = Comentario.class,
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<Comentario> comentarios;
	
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

	public Set<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
