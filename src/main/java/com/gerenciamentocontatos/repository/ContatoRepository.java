package com.gerenciamentocontatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentocontatos.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
    List<Contato> findByNomeContainingIgnoreCase(String nome);
    List<Contato> findByGrupoId(Long grupoId);
}
