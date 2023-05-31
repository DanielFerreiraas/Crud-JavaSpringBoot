package br.edu.uninassau.contato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uninassau.contato.repository.ContatoRepository;
import br.edu.uninassau.contato.entity.Contato;

@RestController
public class ContatoController {
	@Autowired
	ContatoRepository contatoRepository;
	
	@PostMapping("/contato")
	public String saveContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
		return "contato salvo com sucesso";
	}

}

