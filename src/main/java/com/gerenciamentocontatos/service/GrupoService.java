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

    public Grupo save(Grupo grupo){
        if(grupo.getNome() == null || grupo.getNome().trim().isEmpty()){
            throw new RuntimeException("Nome do grupo é obrigatório");
        }
        return grupoRepository.save(grupo);
    }

    public Grupo update(Long id, Grupo grupoAtualizado){
        return grupoRepository.findById(id)
                .map(grupo -> {
                    grupo.setNome(grupoAtualizado.getNome());
                    grupo.setDescricao(grupoAtualizado.getDescricao());
                    return grupoRepository.save(grupo);
                })
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + id));
    }

    public void deletebyId(Long id){
        if(!grupoRepository.existsById(id)){
            throw new RuntimeException("Grupo não encontrado com id: " + id);
        }
        grupoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return grupoRepository.existsById(id);
    }
}
