package com.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.ISecaoDAO;
import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Secao;
import com.jornal.model.Usuario;

@Controller
public class UsuarioEditorController {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@RequestMapping("/gerenciarJornalistas")
	public String gerenciarJornalistas(Model model){
		List<Usuario> jornalistas = usuarioDao.findByTipoLike(2);
		model.addAttribute("jornalistas", jornalistas);
		return "editor/gerenciarJornalistas";
	}
	
	@RequestMapping("/gerenciarSecoes")
	public String gerenciarSecoes(HttpSession session){
		return "editor/gerenciarSecoes";
	}
	
	@RequestMapping("/removerNoticias")
	public String removerNoticias(){
		return "editor/removerNoticias";
	}
	
}
