package com.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.INoticiaDAO;
import com.jornal.model.Noticia;
import com.jornal.model.Usuario;

@Controller
public class NoticiaController {

	@Autowired
	private INoticiaDAO noticiaDao;
	
	@RequestMapping("/mostraNoticia")
	public String mostraNoticia(long id, HttpSession session, Model model){
		Noticia noticia = noticiaDao.findOne(id);
		model.addAttribute("noticia", noticia);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			if(usuario.getTipo() == 1)
				return "leitor/noticia";
		}
			
		return "noticia";
	}
	
	@RequestMapping("/listarPorSecao")
	public String listarPorSecao(long secaoId, HttpSession session, Model model){
		List<Noticia> noticias = noticiaDao.findBySecao(secaoId);
		model.addAttribute("noticias", noticias);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			if(usuario.getTipo() == 1)
				return "leitor/noticia";
		}
		return "home";
	}
	
}
