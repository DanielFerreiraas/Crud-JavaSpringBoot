package br.edu.uninassau.contato.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/contato")
	public List<Contato> getContatos(){
		return contatoRepository.findAll();
	}
	
	@PutMapping("/contato")
	public String updateContato(@RequestParam(name="id")Long id,@RequestBody Contato contatoUpdate) {
		Optional<Contato> oldContato = contatoRepository.findById(id);
		String msg = null;
		
		if(oldContato.isPresent()) {
			Contato contato = oldContato.get();
			contato.setNome(contatoUpdate.getNome());
			contato.setEmail(contatoUpdate.getEmail());
			contatoRepository.save(contato);
			msg = "Contato atualizado com sucesso";
		}else {
			msg = "Contato não encontrado";
		}
		return msg;
	}
	
		
		@DeleteMapping("/contato")
		public String deleteContato(@RequestParam(name="id")Long id) {
			Optional<Contato> Contato = contatoRepository.findById(id);
			String msg = null;
			
			if(Contato.isPresent()) {
				contatoRepository.delete(Contato.get());
				msg = "Contato excluído com sucesso";
			}else {
				msg = "Não foi possível excluir";
			}
			
			return msg;
	}
	
	
	
	
	
	
	

}

