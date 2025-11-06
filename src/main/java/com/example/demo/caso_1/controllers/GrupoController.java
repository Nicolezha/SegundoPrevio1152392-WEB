package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Grupo;
import com.example.demo.caso_1.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Long id) {
        return grupoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Grupo createGrupo(@RequestBody Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Long id, @RequestBody Grupo grupoDetails) {
        return grupoRepository.findById(id)
                .map(grupo -> {
                    grupo.setNumero(grupoDetails.getNumero());
                    grupo.setAsignatura(grupoDetails.getAsignatura());
                    return ResponseEntity.ok(grupoRepository.save(grupo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}