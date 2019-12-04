package com.contatos.contatos.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.contatos.model.Telefone;
import com.contatos.contatos.repository.TelefoneRepository;

@RestController
@RequestMapping("/numero")
@CrossOrigin(origins = "*")
public class TelefoneResouce {
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	@GetMapping("/{id}")
	public List<Telefone> listar(@PathVariable Long id) {
		return telefoneRepository.findByCadastroId(id);
	}
	
	@PutMapping("/{id}")
	public Telefone atualizar(@PathVariable Long id, @Valid @RequestBody Telefone telefone) {
		Telefone telefoneAtualizado = telefoneRepository.save(telefone);
		
		return telefoneAtualizado;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Telefone criar(@RequestBody Telefone telefone) {
		Telefone telefoneValidacao = telefoneRepository.findBytelefone(telefone.getTelefone());
		if(telefoneValidacao != null) {
			return null;
		}
		else {
			return telefoneRepository.save(telefone);		
		}

	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		telefoneRepository.deleteById(id);
	}
}
