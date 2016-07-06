package com.jornal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "classificado")
public class Classificado {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false, length = 1000000000)
	private String texto;
	
	@Column(nullable = false)
	private double preco;
	
	@Column(nullable = false)
	private String telefone;
	
	private double melhorOferta;
	
	@Temporal(TemporalType.DATE)
	private Date dataOferta;
	
	@Column(columnDefinition = "bool default false")
	private boolean vendido;
	
	@Column(nullable = false)
	private double valorIntervalo;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")
	private Usuario comprador;
	
	@Column(name = "usuario_id", updatable = false, insertable = false, nullable = true)
	private Long usuarioId;
	
	@Column(updatable = false)
	private String imgClassificado;
	
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(double melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public boolean isVendido() {
		return vendido;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public double getValorIntervalo() {
		return valorIntervalo;
	}

	public void setValorIntervalo(double valorIntervalo) {
		this.valorIntervalo = valorIntervalo;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getImgClassificado() {
		return imgClassificado;
	}

	public void setImgClassificado(String imgClassificado) {
		this.imgClassificado = imgClassificado;
	}

	
}
