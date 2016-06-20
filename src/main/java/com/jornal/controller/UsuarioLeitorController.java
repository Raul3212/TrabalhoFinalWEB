package com.jornal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Usuario;
import com.jornal.util.HashMD5;

@Controller
public class UsuarioLeitorController {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@RequestMapping("/cadastroLeitorFormulario")
	public String cadastroLeitorFormulario(){
		return "cadastroLeitorFormulario";
	}

	@RequestMapping("/cadastrarLeitor")
	public String cadastrarLeitor(Usuario usuario){
		usuario.setSenha(HashMD5.getCriptografado(usuario.getSenha()));
		usuarioDao.save(usuario);
		return "redirect:/";
	}
	
}
