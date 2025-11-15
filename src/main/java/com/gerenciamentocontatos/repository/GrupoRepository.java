package com.gerenciamentocontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentocontatos.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    
}
