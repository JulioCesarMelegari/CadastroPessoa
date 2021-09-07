package com.JCM.Pessoa.service;


import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.JCM.Pessoa.dto.PessoaDTO;
import com.JCM.Pessoa.entity.Pessoa;
import com.JCM.Pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Page<PessoaDTO> findAll(Pageable pageable){
		Page<Pessoa> result = repository.findAll(pageable);
		return result.map(x -> new PessoaDTO(x));
	}
	
	public Pessoa pessoaId(Long id) {
		return repository.findById(id).orElseThrow(()-> new EntityNotFoundException());
	}
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public void excluirPessoa(Long id) {
		repository.deleteById(id);
	}
	
	public List<Pessoa> listarTodos(){
		return repository.findAll();
		
	}

}
