package br.com.fullstack.gerenciamentotutorias.controllers;

import br.com.fullstack.gerenciamentotutorias.entities.TutorEntity;
import br.com.fullstack.gerenciamentotutorias.services.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tutores")
public class TutorController {

    private final TutorService service;

    @PostMapping
    public ResponseEntity<TutorEntity> create (@RequestBody TutorEntity tutor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tutor));
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> readAll (){
        return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> readById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> update (@PathVariable Long id, @RequestBody TutorEntity tutor){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, tutor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TutorEntity> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
        //return ResponseEntity.noContent().build();
    }

}
