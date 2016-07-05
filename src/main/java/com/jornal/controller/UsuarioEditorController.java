package com.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.IClassificadoDAO;
import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Classificado;
import com.jornal.model.Usuario;

@Controller
public class UsuarioEditorController {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private IClassificadoDAO classificadoDao;
	
	@RequestMapping("/gerenciarJornalistas")
	public String gerenciarJornalistas(Model model){
		List<Usuario> jornalistas = usuarioDao.findByTipoLike(2);
		model.addAttribute("jornalistas", jornalistas);
		return "editor/gerenciarJornalistas";
	}
	
	@RequestMapping("/gerenciarSecoes")
	public String gerenciarSecoes(){
		return "editor/gerenciarSecoes";
	}
	
	@RequestMapping("/removerNoticias")
	public String removerNoticias(){
		return "editor/removerNoticias";
	}
	
}
