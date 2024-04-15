package br.com.fullstack.gerenciamentotutorias.services;

import br.com.fullstack.gerenciamentotutorias.entities.MaterialEntity;
import br.com.fullstack.gerenciamentotutorias.exceptions.NotFountException;
import br.com.fullstack.gerenciamentotutorias.repositories.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository repository;

    public MaterialEntity create(MaterialEntity material){
        return repository.save(material);
    }

    public MaterialEntity readById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFountException("Aluno não lozalizado"));
    }

    public List<MaterialEntity> readAll(){
        return repository.findAll();
    }

    public MaterialEntity update (Long id, MaterialEntity material){
        readById(id);
        material.setId(id);
        return repository.save(material);
    }

    public void delete (Long id){
        MaterialEntity aluno = readById(id);
        repository.delete(aluno);
    }

}
