package br.com.fullstack.gerenciamentotutorias.services;

import br.com.fullstack.gerenciamentotutorias.entities.AlunoEntity;
import br.com.fullstack.gerenciamentotutorias.exceptions.NotFountException;
import br.com.fullstack.gerenciamentotutorias.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoEntity create(AlunoEntity aluno){
        return repository.save(aluno);
    }

    public AlunoEntity readById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFountException("Aluno não lozalizado"));
    }

    public List<AlunoEntity> readAll(){
        return repository.findAll();
    }

    public AlunoEntity update (Long id, AlunoEntity aluno){
        readById(id);
        aluno.setId(id);
        return repository.save(aluno);
    }

    public void delete (Long id){
        AlunoEntity aluno = readById(id);
        repository.delete(aluno);
    }

}
