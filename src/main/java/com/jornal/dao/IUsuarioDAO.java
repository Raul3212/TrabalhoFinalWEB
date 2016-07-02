package com.jornal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jornal.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>, IUsuarioDAOCustom{

}
