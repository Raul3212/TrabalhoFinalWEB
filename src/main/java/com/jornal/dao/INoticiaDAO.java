package com.jornal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jornal.model.Noticia;

@Repository
public interface INoticiaDAO extends JpaRepository<Noticia, Long>{

	@Query("select n from noticia as n order by n.data desc")
	public List<Noticia> findAllOrderByData();
	
	@Query("select n from noticia as n where secao_id = :paramSecaoId")
	public List<Noticia> findBySecao(@Param("paramSecaoId")long secaoId);
	
}
