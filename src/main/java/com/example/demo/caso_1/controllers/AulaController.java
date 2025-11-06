package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Aula;
import com.example.demo.caso_1.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @GetMapping
    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getAulaById(@PathVariable Long id) {
        return aulaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula) {
        return aulaRepository.save(aula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula aulaDetails) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aula.setNombre(aulaDetails.getNombre());
                    aula.setCapacidad(aulaDetails.getCapacidad());
                    return ResponseEntity.ok(aulaRepository.save(aula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Long id) {
        if (aulaRepository.existsById(id)) {
            aulaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}