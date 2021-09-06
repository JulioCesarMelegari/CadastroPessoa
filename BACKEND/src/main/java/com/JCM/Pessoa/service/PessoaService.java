package com.JCM.Pessoa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCM.Pessoa.dto.PessoaDTO;
import com.JCM.Pessoa.entity.Pessoa;
import com.JCM.Pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<PessoaDTO> findAll(){
		List<Pessoa> result = repository.findAll();
		return result.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

}
