package com.JCM.Pessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JCM.Pessoa.dto.ContatoDTO;
import com.JCM.Pessoa.service.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<Page<ContatoDTO>> findAll(Pageable pageable){
		Page<ContatoDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
}
