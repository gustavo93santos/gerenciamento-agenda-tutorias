package br.com.fullstack.gerenciamentotutorias.controllers;

import br.com.fullstack.gerenciamentotutorias.entities.AgendaEntity;
import br.com.fullstack.gerenciamentotutorias.services.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("agendas")
public class AgendaController {

    private final AgendaService service;

    @PostMapping
    public ResponseEntity<AgendaEntity> create (@RequestBody AgendaEntity agenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(agenda));
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> readAll (){
        return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> readById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> update (@PathVariable Long id, @RequestBody AgendaEntity agenda){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AgendaEntity> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
        //return ResponseEntity.noContent().build();
    }

    @GetMapping("aluno-id/{id}")
    public ResponseEntity<List<AgendaEntity>> readByAlunoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readByAlunoId(id));
    }

    @GetMapping("tutor-id/{id}")
    public ResponseEntity<List<AgendaEntity>> readByTutorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readByTutorId(id));
    }

    @GetMapping("aluno-id/{id}/agendas-futuras")
    public ResponseEntity<List<AgendaEntity>> readByAlunoIdAgendamentosFuturos(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readByAlunoIdAgendamentosFuturos(id));
    }

    @GetMapping("tutor-id/{id}/agendas-futuras")
    public ResponseEntity<List<AgendaEntity>> readByTutorAgendamentosFuturos(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.readByTutorAgendamentosFuturos(id));
    }

}
