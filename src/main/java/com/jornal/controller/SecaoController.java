package com.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jornal.dao.ISecaoDAO;
import com.jornal.model.Secao;

@Controller
public class SecaoController {

	@Autowired
	private ISecaoDAO secaoDao;
	
	@RequestMapping("/removerSecao")
	public String removerSecao(long id, HttpSession session){
		List<Secao> secoes = (List<Secao>)session.getAttribute("secoes");
		Secao dummy = new Secao();
		dummy.setId(id);
		secoes.remove(dummy);
		session.setAttribute("secoes", secoes);
		secaoDao.delete(id);
		return "redirect:gerenciarSecoes";
	}
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "editor/inserirSecaoFormulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(Secao secao, HttpSession session){
		List<Secao> secoes = (List<Secao>)session.getAttribute("secoes");
		int index = secoes.indexOf(secao);
		if(index >= 0){
			secoes.remove(secao);
			secoes.add(index, secao);
		}else{
			secoes.add(secao);
		}
		session.setAttribute("secoes", secoes);
		secaoDao.save(secao);
		return "redirect:gerenciarSecoes";
	}
	
	@RequestMapping("/editarSecaoFormulario")
	public String inserirSecaoFormulario(long id, Model model){
		Secao secao = secaoDao.findOne(id);
		model.addAttribute("secao", secao);
		return "editor/editarSecaoFormulario";
	}
	
}
