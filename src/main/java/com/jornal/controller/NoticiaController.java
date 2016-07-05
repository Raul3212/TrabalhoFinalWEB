package com.jornal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			else if (usuario.getTipo() == Usuario.JORNALISTA)
				return "jornalista/noticia";
			else if (usuario.getTipo() == Usuario.EDITOR)
				return "editor/noticia";
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
			else if (usuario.getTipo() == Usuario.JORNALISTA)
				return "jornalista/menu";
			else if (usuario.getTipo() == Usuario.EDITOR)
				return "editor/menu";
		}
		return "home";
	}
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(){
		return "jornalista/inserirNoticiaFormulario";
	}
	
	@RequestMapping("/cadastrarNoticia")
	public String cadastrarNoticia(Noticia noticia, HttpSession session){
		Secao secao = secaoDao.findOne(noticia.getSecaoId());
		noticia.setSecao(secao);
		Usuario usuario = usuarioDao.findOne(noticia.getUsuarioId());
		noticia.setUsuario(usuario);
		noticia.setData(new Date());
		noticiaDao.save(noticia);
		usuario.getNoticias().add(noticia);
		session.setAttribute("usuario", usuario);
		return "redirect:gerenciarNoticias";
	}
		
	@RequestMapping("/editarNoticiaFormulario")
	public String editarNoticiaFormulario(long id, Model model){
		Noticia noticia = noticiaDao.findOne(id);
		model.addAttribute("noticia", noticia);
		List<Secao> secoes = secaoDao.findAll();
		model.addAttribute("secoes", secoes);
		return "jornalista/editarNoticiaFormulario";
	}
	
	@RequestMapping("/editarNoticia")
	public String editarNoticia(Noticia noticia, HttpSession session){
		Secao secao = secaoDao.findOne(noticia.getSecaoId());
		noticia.setSecao(secao);
		Usuario usuario = usuarioDao.findOne(noticia.getUsuarioId());
		noticia.setUsuario(usuario);
		noticia.setData(new Date());
		noticiaDao.save(noticia);
		usuario.getNoticias().remove(noticia);
		usuario.getNoticias().add(noticia);
		session.setAttribute("usuario", usuario);
		return "redirect:gerenciarNoticias";
	}
	
	@RequestMapping("/removerNoticia")
	public String removerNoticia(long id, HttpSession session){
		Noticia dummy = new Noticia();
		dummy.setId(id);
		noticiaDao.delete(id);
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario.getTipo() == Usuario.JORNALISTA){
			usuario.getNoticias().remove(dummy);
			session.setAttribute("usuario", usuario);
			return "redirect:gerenciarNoticias";
		}
		else if(usuario.getTipo() == Usuario.EDITOR){
			System.out.println("Etrou");
			return "redirect:removerNoticias";
		}
		return "/";
	}
	
}
