package com.jornal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jornal.model.Secao;

@Repository
public interface ISecaoDAO extends JpaRepository<Secao, Long>{

}
