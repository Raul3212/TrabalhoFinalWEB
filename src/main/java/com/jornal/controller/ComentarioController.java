package com.jornal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.IComentarioDAO;
import com.jornal.dao.INoticiaDAO;
import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Comentario;
import com.jornal.model.Noticia;
import com.jornal.model.Usuario;

@Controller
public class ComentarioController {

	@Autowired
	private IComentarioDAO comentarioDao;
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private INoticiaDAO noticiaDao;
	
	@RequestMapping("/publicarComentario")
	public String publicarComentario(Comentario comentario){
		Noticia n = noticiaDao.findOne(comentario.getNoticiaId());
		Usuario u = usuarioDao.findOne(comentario.getUsuarioId());
		comentario.setNoticia(n);
		comentario.setUsuario(u);
		comentarioDao.save(comentario);
		return "redirect:mostraNoticia?id=" + comentario.getNoticiaId();
	}
	
}
