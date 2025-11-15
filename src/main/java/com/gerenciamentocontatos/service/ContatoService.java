package com.gerenciamentocontatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentocontatos.model.Contato;
import com.gerenciamentocontatos.model.Grupo;
import com.gerenciamentocontatos.repository.ContatoRepository;
import com.gerenciamentocontatos.repository.GrupoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> findById(Long Id) {
        return contatoRepository.findById(Id);
    }

    public Contato save(Contato contato) {
        if (contato.getNome() == null || contato.getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome do contato é obrigatório");
        }

        if (contato.getGrupo() != null && contato.getGrupo().getId() != null) {
            Grupo grupo = grupoRepository.findById(contato.getGrupo().getId())
                    .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
            contato.setGrupo(grupo);
        }
        return contatoRepository.save(contato);
    }

    public Contato update(Long id, Contato contatoAtualizado) {
        return contatoRepository.findById(id)
                .map(contato -> {
                    contato.setNome(contatoAtualizado.getNome());
                    contato.setEmail(contatoAtualizado.getEmail());
                    contato.setTelefone(contatoAtualizado.getTelefone());
                    contato.setEndereco(contatoAtualizado.getEndereco());
                    contato.setDataNascimento(contatoAtualizado.getDataNascimento());
                    contato.setObservacoes(contatoAtualizado.getObservacoes());

                    // Atualiza grupo se fornecido
                    if (contatoAtualizado.getGrupo() != null && contatoAtualizado.getGrupo().getId() != null) {
                        Grupo grupo = grupoRepository.findById(contatoAtualizado.getGrupo().getId())
                                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
                        contato.setGrupo(grupo);
                    }

                    return contatoRepository.save(contato);
                })
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com id: " + id));
    }

    public void deleteById(Long id) {
        if (!contatoRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado com id: " + id);
        }
        contatoRepository.deleteById(id);
    }

    public List<Contato> findByNome(String nome) {
        return contatoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Contato> findByGrupoId(Long grupoId) {
        return contatoRepository.findByGrupoId(grupoId);
    }
}
