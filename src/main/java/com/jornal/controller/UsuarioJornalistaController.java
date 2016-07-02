package com.jornal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Usuario;
import com.jornal.util.HashMD5;

@Controller
public class UsuarioJornalistaController {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@RequestMapping("/inserirJornalistaFormulario")
	public String inserirJornalistaFormulario(){
		return "editor/inserirJornalistaFormulario";
	}
	
	@RequestMapping("/inserirJornalista")
	public String inserirJornalista(Usuario usuario){
		usuario.setSenha(HashMD5.getCriptografado(usuario.getSenha()));
		usuarioDao.save(usuario);
		return "redirect:gerenciarJornalistas";
	}
	
	@RequestMapping("/editarJornalistaFormulario")
	public String editarJornalistaFormulario(long id, Model model){
		Usuario jornalista = usuarioDao.findOne(id);
		model.addAttribute("jornalista", jornalista);
		return "editor/editarJornalistaFormulario";
	}
	
	@RequestMapping("/editarJornalista")
	public String editarJornalista(Usuario usuario){
		usuarioDao.save(usuario);
		return "redirect:gerenciarJornalistas";
	}
	
	@RequestMapping("/removerJornalista")
	public String removerJornalista(long id){
		usuarioDao.delete(id);
		return "redirect:gerenciarJornalistas";
	}
	
	@RequestMapping("/gerenciarNoticias")
	public String gerenciarNoticias(HttpSession session, Model model){
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		model.addAttribute("noticias", usuario.getNoticias());
		return "jornalista/minhasNoticias";
	}
	
}
