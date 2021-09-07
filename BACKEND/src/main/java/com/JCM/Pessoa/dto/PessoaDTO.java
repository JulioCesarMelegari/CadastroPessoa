package com.JCM.Pessoa.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;

import com.JCM.Pessoa.entity.Pessoa;

public class PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message="{pessoa.descricao.not-blank}")
	@Column(nullable = false)
	private String nome;
	
	@CPF(message = "{pessoa.descricao.cpf}")
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@PastOrPresent(message = "{pessoa.descricao.past-or-present}")
	@Column(nullable = false)
	private LocalDate datanasc;
	
	public PessoaDTO() {
		
	}

	public PessoaDTO(Long id, String nome, String cpf, LocalDate datanasc) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
	}
	
	public PessoaDTO(Pessoa entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		datanasc = entity.getDatanasc();
		
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}

}
