package com.jornal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.jornal.model.Usuario;

public class UsuarioDAOCustomEditImpl implements IUsuarioDAOCustomEdit{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void updateUsuario(Usuario usuario) {
		String hql = "update usuario set nome = :nome, email = :email, "
				+ "login = :login where id = :id";
		
		Query query = manager.createQuery(hql);
		query.setParameter(":nome", usuario.getNome());
		query.setParameter(":email", usuario.getEmail());
		query.setParameter(":login", usuario.getLogin());
		query.setParameter(":id", usuario.getId());
		
		query.executeUpdate();
	}

}
