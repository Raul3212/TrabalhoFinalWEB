package com.jornal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jornal.model.Comentario;

@Repository
public interface IComentarioDAO extends JpaRepository<Comentario, Long>{

}
