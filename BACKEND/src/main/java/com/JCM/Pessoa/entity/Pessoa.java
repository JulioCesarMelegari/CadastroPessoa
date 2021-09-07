package com.JCM.Pessoa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_Pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoa_id")
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
	
	@NotBlank
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Contato> contatos = new ArrayList<>();

	public Pessoa() {
	
	}

	public Pessoa(Long id, String nome, String cpf, LocalDate datanasc, List<Contato> contatos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
		this.contatos = contatos;
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

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}