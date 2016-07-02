package com.jornal.controller;

import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.INoticiaDAO;
import com.jornal.dao.ISecaoDAO;
import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Noticia;
import com.jornal.model.Secao;
import com.jornal.model.Usuario;

@Controller
public class NoticiaController {

	@Autowired
	private INoticiaDAO noticiaDao;
	
	@Autowired
	private ISecaoDAO secaoDao;
	
	@Autowired
	private IUsuarioDAO usuarioDao;
		
	@RequestMapping("/mostraNoticia")
	public String mostraNoticia(long id, HttpSession session, Model model){
		Noticia noticia = noticiaDao.findOne(id);
		model.addAttribute("noticia", noticia);
		model.addAttribute("comentarios", noticia.getComentarios());
		
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			if(usuario.getTipo() == Usuario.LEITOR)
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
			if(usuario.getTipo() == Usuario.LEITOR)
				return "leitor/menu";
		}
		return "home";
	}
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(){
		return "jornalista/inserirNoticiaFormulario";
	}
	
	@RequestMapping("/cadastrarNoticia")
	public String cadastrarNoticia(Noticia noticia){
		Secao secao = secaoDao.findOne(noticia.getSecaoId());
		noticia.setSecao(secao);

		Usuario usuario = usuarioDao.findOne(noticia.getUsuarioId());
		noticia.setUsuario(usuario);
		
		noticiaDao.save(noticia);
		return "redirect:gerenciarNoticias";
	}
	
	@RequestMapping("/removerNoticia")
	public String removerNoticia(long id, HttpSession session){
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		Noticia dummy = new Noticia();
		dummy.setId(id);
		usuario.getNoticias().remove(dummy);
		noticiaDao.delete(id);
		return "redirect:gerenciarNoticias";
	}
	
}
