package com.jornal.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jornal.dao.IUsuarioDAO;
import com.jornal.model.Usuario;
import com.jornal.util.FileUpload;
import com.jornal.util.HashMD5;

@Controller
public class UsuarioLeitorController {

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/cadastroLeitorFormulario")
	public String cadastroLeitorFormulario(){
		return "cadastroLeitorFormulario";
	}

	@RequestMapping("/cadastrarLeitor")
	public String cadastrarLeitor(Usuario usuario, 
			@RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		if(imagem != null && !imagem.isEmpty()){
			String fileName = usuario.getNome() + "_" + usuario.getId() + imagem.getOriginalFilename();
			String path = servletContext.getRealPath("/") + "/resources/img/perfil/" + fileName;
			FileUpload.saveFile(path, imagem);
			usuario.setImgPerfil(fileName);
		}
		
		usuario.setSenha(HashMD5.getCriptografado(usuario.getSenha()));
		usuarioDao.save(usuario);
		return "redirect:loginFormulario";
	}
	
}
