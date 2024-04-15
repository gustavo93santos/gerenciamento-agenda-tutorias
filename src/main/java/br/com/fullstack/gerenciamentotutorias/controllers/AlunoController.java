package br.com.fullstack.gerenciamentotutorias.controllers;

import br.com.fullstack.gerenciamentotutorias.entities.AlunoEntity;
import br.com.fullstack.gerenciamentotutorias.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoEntity> create (@RequestBody AlunoEntity aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> readAll (){
        return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> readById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> update (@PathVariable Long id, @RequestBody AlunoEntity aluno){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, aluno));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AlunoEntity> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
        //return ResponseEntity.noContent().build();
    }

}
