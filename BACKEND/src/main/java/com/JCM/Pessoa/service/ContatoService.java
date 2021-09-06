package com.JCM.Pessoa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCM.Pessoa.dto.ContatoDTO;
import com.JCM.Pessoa.entity.Contato;
import com.JCM.Pessoa.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<ContatoDTO> findAll(){
		List<Contato> result = repository.findAll();
		return result.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}
}
