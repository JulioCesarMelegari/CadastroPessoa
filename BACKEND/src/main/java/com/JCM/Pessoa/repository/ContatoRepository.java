package com.JCM.Pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JCM.Pessoa.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
