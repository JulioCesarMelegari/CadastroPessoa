package com.JCM.Pessoa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.JCM.Pessoa.service.PessoaService;

@SpringBootTest
public class TestPessoa {
	
	private PessoaService service;
	
	@Test
	void buscarTodos() {
		service.listarTodos();
	}
}
