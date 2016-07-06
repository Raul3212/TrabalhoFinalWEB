package com.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.INoticiaDAO;
import com.jornal.dao.ISecaoDAO;
import com.jornal.model.Noticia;
import com.jornal.model.Secao;

@Controller
public class RootController {

	@Autowired
	private ISecaoDAO secaoDao;
	@Autowired
	private INoticiaDAO noticiaDao; 
	
	@RequestMapping("/")
	public String home(HttpSession session, Model model){
		List<Secao> secoes = secaoDao.findAll();
		List<Noticia> noticias = noticiaDao.findAllOrderByData(); 
		session.setAttribute("secoes", secoes);
		model.addAttribute("noticias", noticias);
		return "home";
	}
	
}
