package com.JCM.Pessoa.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import com.JCM.Pessoa.entity.Contato;

public class ContatoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	@Email(message = "{contato.descricao.email}")
	@Column(nullable = false)
	private String email;
	
	
	private PessoaDTO pessoaDto;
	
	public ContatoDTO() {
		
	}	
	
	public ContatoDTO(Long id, String nome, String telefone, String email, PessoaDTO pessoaDto) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.pessoaDto = pessoaDto;
	}

	public ContatoDTO(Contato entity) {
		id = entity.getId();
		nome = entity.getNome();
		telefone = entity.getTelefone();
		email = entity.getEmail();
		pessoaDto = new PessoaDTO(entity.getPessoa());
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PessoaDTO getPessoaDto() {
		return pessoaDto;
	}
	public void setPessoaDto(PessoaDTO pessoaDto) {
		this.pessoaDto = pessoaDto;
	}

}
