package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Inscripcion;
import com.example.demo.caso_1.repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable Long id) {
        return inscripcionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcionDetails) {
        return inscripcionRepository.findById(id)
                .map(inscripcion -> {
                    inscripcion.setListaEspera(inscripcionDetails.getListaEspera());
                    inscripcion.setEstado(inscripcionDetails.getEstado());
                    return ResponseEntity.ok(inscripcionRepository.save(inscripcion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable Long id) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}