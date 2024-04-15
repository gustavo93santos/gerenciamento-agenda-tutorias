package br.com.fullstack.gerenciamentotutorias.controllers;

import br.com.fullstack.gerenciamentotutorias.entities.MaterialEntity;
import br.com.fullstack.gerenciamentotutorias.services.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("materiais")
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    public ResponseEntity<MaterialEntity> create (@RequestBody MaterialEntity material){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(material));
    }

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> readAll (){
        return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<MaterialEntity> readById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<MaterialEntity> update (@PathVariable Long id, @RequestBody MaterialEntity material){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, material));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MaterialEntity> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
        //return ResponseEntity.noContent().build();
    }

}
