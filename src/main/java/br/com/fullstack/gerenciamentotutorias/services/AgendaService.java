package br.com.fullstack.gerenciamentotutorias.services;

import br.com.fullstack.gerenciamentotutorias.entities.AgendaEntity;
import br.com.fullstack.gerenciamentotutorias.entities.AlunoEntity;
import br.com.fullstack.gerenciamentotutorias.entities.TutorEntity;
import br.com.fullstack.gerenciamentotutorias.exceptions.NotFountException;
import br.com.fullstack.gerenciamentotutorias.repositories.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository repository;
    private final AlunoService alunoService;
    private final TutorService tutorService;


    public AgendaEntity create(AgendaEntity agenda){

        AlunoEntity aluno = alunoService.readById(agenda.getAluno().getId());
        agenda.setAluno(aluno);

        TutorEntity tutor = tutorService.readById(agenda.getTutor().getId());
        agenda.setTutor(tutor);

        return repository.save(agenda);
    }

    public AgendaEntity readById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFountException("Aluno não lozalizado"));
    }

    public List<AgendaEntity> readAll(){
        return repository.findAll();
    }

    public AgendaEntity update (Long id, AgendaEntity agenda){
        readById(id);
        agenda.setId(id);
        return repository.save(agenda);
    }

    public void delete (Long id){
        AgendaEntity aluno = readById(id);
        repository.delete(aluno);
    }

}
