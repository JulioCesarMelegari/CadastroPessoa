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

import com.JCM.Pessoa.dto.PessoaDTO;
import com.JCM.Pessoa.entity.Pessoa;
import com.JCM.Pessoa.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<Page<PessoaDTO>> findAll(Pageable pageable){
		Page<PessoaDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public Pessoa pessoaId(@PathVariable Long id) {
		return service.pessoaId(id);
	}
	
	@PostMapping("/tarefa")
	public Pessoa salvarPessoa(@Valid @RequestBody Pessoa pessoa) {
		return service.salvarPessoa(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public Pessoa deletePessoa(@PathVariable Long id) {
		service.excluirPessoa(id);
		return null;
	}
	
}
