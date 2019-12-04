package com.contatos.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.contatos.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	
	Cadastro findByNome(String nome);

}
