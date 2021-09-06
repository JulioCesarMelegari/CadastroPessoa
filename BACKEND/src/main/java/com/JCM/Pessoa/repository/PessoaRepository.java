package com.JCM.Pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JCM.Pessoa.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
