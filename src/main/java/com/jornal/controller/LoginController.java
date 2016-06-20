package com.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Login;
import com.jornal.model.Usuario;
import com.jornal.util.HashMD5;

@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioDAO usuarioDao;
		
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login";
	}
	
	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Login login, HttpSession session){
		
		login.setSenha(HashMD5.getCriptografado(login.getSenha()));
		
		List<Usuario> candidatos = usuarioDao.findByLoginLike(login.getLogin());
		
		if(!candidatos.isEmpty()){
			if(candidatos.get(0).getSenha().equals(login.getSenha()) 
					&& candidatos.get(0).getTipo() == login.getTipo()){
				session.setAttribute("usuario", candidatos.get(0));
				if(login.getTipo() == 1)
					return "leitor/menu";
				if(login.getTipo() == 2)
					return "jornalista/menu";
				if(login.getTipo() == 3)
					return "editor/menu";
			}
		}
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/efetuarLogout")
	public String efetuarLogout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
