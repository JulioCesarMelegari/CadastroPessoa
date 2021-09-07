package com.JCM.Pessoa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.JCM.Pessoa.dto.ContatoDTO;
import com.JCM.Pessoa.entity.Contato;
import com.JCM.Pessoa.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public Page<ContatoDTO> findAll(Pageable pageable){
		Page<Contato> result = repository.findAll(pageable);
		return result.map(x -> new ContatoDTO(x));
	}
}
