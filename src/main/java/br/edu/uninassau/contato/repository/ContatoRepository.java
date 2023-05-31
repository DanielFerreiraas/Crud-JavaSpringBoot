package br.edu.uninassau.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uninassau.contato.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
}
