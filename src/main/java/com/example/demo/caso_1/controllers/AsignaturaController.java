package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Asignatura;
import com.example.demo.caso_1.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @GetMapping
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable Long id) {
        return asignaturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        return asignaturaRepository.findById(id)
                .map(asignatura -> {
                    asignatura.setNombre(asignaturaDetails.getNombre());
                    asignatura.setCodigo(asignaturaDetails.getCodigo());
                    asignatura.setCreditos(asignaturaDetails.getCreditos());
                    asignatura.setPrerrequisitos(asignaturaDetails.getPrerrequisitos());
                    asignatura.setCorrequisitos(asignaturaDetails.getCorrequisitos());
                    asignatura.setGrupo(asignaturaDetails.getGrupo());
                    return ResponseEntity.ok(asignaturaRepository.save(asignatura));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        if (asignaturaRepository.existsById(id)) {
            asignaturaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}