package com.gerenciamentocontatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentocontatos.model.Grupo;
import com.gerenciamentocontatos.repository.GrupoRepository;

@Service
public class GrupoService {
    
    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> findAll(){
        return grupoRepository.findAll();
    }

    public Optional<Grupo> findById(Long id){
        return grupoRepository.findById(id);
    }
}
