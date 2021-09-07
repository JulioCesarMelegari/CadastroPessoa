package com.JCM.Pessoa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public Pessoa pessoaId(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public void excluirPessoa(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
