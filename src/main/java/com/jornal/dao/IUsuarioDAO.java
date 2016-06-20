package com.jornal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jornal.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>, IUsuarioDAOCustom{

}
