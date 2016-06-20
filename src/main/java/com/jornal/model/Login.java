package com.jornal.model;

public class Login {

	private String login;
	private String senha;
	private int tipo;
	
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
	public void setTipo(int tipoLogin) {
		this.tipo = tipoLogin;
	}
	
}
