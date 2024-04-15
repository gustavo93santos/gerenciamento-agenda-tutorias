package br.com.fullstack.gerenciamentotutorias.services;

import br.com.fullstack.gerenciamentotutorias.entities.TutorEntity;
import br.com.fullstack.gerenciamentotutorias.exceptions.NotFountException;
import br.com.fullstack.gerenciamentotutorias.repositories.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository repository;

    public TutorEntity create(TutorEntity Tutor){
        return repository.save(Tutor);
    }

    public TutorEntity readById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFountException("Tutor não lozalizado"));
    }

    public List<TutorEntity> readAll(){
        return repository.findAll();
    }

    public TutorEntity update (Long id, TutorEntity Tutor){
        readById(id);
        Tutor.setId(id);
        return repository.save(Tutor);
    }

    public void delete (Long id){
        TutorEntity aluno = readById(id);
        repository.delete(aluno);
    }

}
