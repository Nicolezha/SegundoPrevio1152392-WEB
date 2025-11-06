package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.PeriodoAcademico;
import com.example.demo.caso_1.repositories.PeriodoAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos-academicos")
public class PeriodoAcademicoController {

    @Autowired
    private PeriodoAcademicoRepository periodoAcademicoRepository;

    @GetMapping
    public List<PeriodoAcademico> getAllPeriodosAcademicos() {
        return periodoAcademicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoAcademico> getPeriodoAcademicoById(@PathVariable Long id) {
        return periodoAcademicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PeriodoAcademico createPeriodoAcademico(@RequestBody PeriodoAcademico periodoAcademico) {
        return periodoAcademicoRepository.save(periodoAcademico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoAcademico> updatePeriodoAcademico(@PathVariable Long id, @RequestBody PeriodoAcademico periodoAcademicoDetails) {
        return periodoAcademicoRepository.findById(id)
                .map(periodoAcademico -> {
                    periodoAcademico.setNombre(periodoAcademicoDetails.getNombre());
                    periodoAcademico.setFechaInicio(periodoAcademicoDetails.getFechaInicio());
                    periodoAcademico.setFechaFin(periodoAcademicoDetails.getFechaFin());
                    return ResponseEntity.ok(periodoAcademicoRepository.save(periodoAcademico));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeriodoAcademico(@PathVariable Long id) {
        if (periodoAcademicoRepository.existsById(id)) {
            periodoAcademicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}