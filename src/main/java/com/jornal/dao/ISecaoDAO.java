package com.jornal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jornal.model.Secao;

public interface ISecaoDAO extends JpaRepository<Secao, Long>{

}
