package com.jornal.dao;

import java.util.List;

import com.jornal.model.Usuario;

public interface IUsuarioDAOCustom{

	public List<Usuario> findByLoginLike(String login);
	public List<Usuario> findByTipoLike(int tipo);
	
}
