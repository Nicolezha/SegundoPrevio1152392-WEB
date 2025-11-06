package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Ajustes;
import com.example.demo.caso_1.repositories.AjustesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ajustes")
public class AjustesController {

    @Autowired
    private AjustesRepository ajustesRepository;

    @GetMapping
    public List<Ajustes> getAllAjustes() {
        return ajustesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ajustes> getAjustesById(@PathVariable Long id) {
        return ajustesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ajustes createAjustes(@RequestBody Ajustes ajustes) {
        return ajustesRepository.save(ajustes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ajustes> updateAjustes(@PathVariable Long id, @RequestBody Ajustes ajustesDetails) {
        return ajustesRepository.findById(id)
                .map(ajustes -> {
                    ajustes.setPeriodoAcademico(ajustesDetails.getPeriodoAcademico());
                    ajustes.setCancelacion(ajustesDetails.getCancelacion());
                    ajustes.setFechaLimite(ajustesDetails.getFechaLimite());
                    ajustes.setFechaCambio(ajustesDetails.getFechaCambio());
                    ajustes.setEstudiantes(ajustesDetails.getEstudiantes());
                    return ResponseEntity.ok(ajustesRepository.save(ajustes));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAjustes(@PathVariable Long id) {
        if (ajustesRepository.existsById(id)) {
            ajustesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}