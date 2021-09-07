package com.JCM.Pessoa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JCM.Pessoa.dto.ContatoDTO;
import com.JCM.Pessoa.entity.Contato;
import com.JCM.Pessoa.service.ContatoService;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<Page<ContatoDTO>> findAll(Pageable pageable){
		Page<ContatoDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public Contato contatoId(@PathVariable Long id) {
		return service.contatoId(id);
	}
	
	@PostMapping("/contato")
	public Contato salvarContato(@Valid @RequestBody Contato contato) {
		return service.salvarContato(contato);
	}
	
	@DeleteMapping("/{id}")
	public Contato deleteContato(@PathVariable Long id) {
		service.excluirContato(id);
		return null;
	}
	
	
}
