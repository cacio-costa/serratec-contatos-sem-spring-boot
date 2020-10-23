package br.com.caelum.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contatos.dao.ContatoDao;
import br.com.caelum.contatos.modelo.Contato;

@Controller
public class ContatosController {

	private ContatoDao dao;

	@Autowired
	public ContatosController(ContatoDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/")
	public String exibe(Model model) {
		List<Contato> contatosParaListagem = dao.lista();
		model.addAttribute("contatos", contatosParaListagem);

		return "listagem-contatos";
	}
	
	@RequestMapping("/novo-contato")
	public String exibeFormulario() {
		return "formulario-contato";
	}
	
	@RequestMapping(value = "/cadastrar-contato")
	public String cadastra(Contato contato) {
		dao.salva(contato);
		
		return "redirect:/";
	}

}
