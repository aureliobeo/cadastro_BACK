package com.contatos.contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.contatos.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	Telefone findBytelefone(Long telefone);
	
	List<Telefone> findByCadastroId(Long cadastroId);
	

}
