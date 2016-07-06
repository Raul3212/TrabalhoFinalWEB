package com.jornal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jornal.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findByLoginLike(String login);
	public List<Usuario> findByTipoLike(int tipo);

}
