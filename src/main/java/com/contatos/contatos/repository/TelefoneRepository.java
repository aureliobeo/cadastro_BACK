package com.contatos.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.contatos.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
