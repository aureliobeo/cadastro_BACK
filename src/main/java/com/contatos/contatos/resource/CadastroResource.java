package com.contatos.contatos.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.contatos.model.Cadastro;
import com.contatos.contatos.repository.CadastroRepository;

@RestController
@RequestMapping("/cadastro")
public class CadastroResource {

	@Autowired
	private CadastroRepository cadastroRepository;

	@GetMapping
	public List<Cadastro> listar() {
		return cadastroRepository.findAll();
	}

	@PutMapping("/{id}")
	public Cadastro atualizar (@PathVariable Long id, @Valid @RequestBody Cadastro cadastro) {
		Cadastro cadastroSalva = cadastroRepository.save(cadastro); 
		return cadastroSalva;
	}

	@PostMapping
	public void criar(@RequestBody Cadastro cadastro) {
		cadastroRepository.save(cadastro);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		cadastroRepository.deleteById(id);
	}

}
