package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Horario;
import com.example.demo.caso_1.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Long id) {
        return horarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioRepository.save(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long id, @RequestBody Horario horarioDetails) {
        return horarioRepository.findById(id)
                .map(horario -> {
                    horario.setAula(horarioDetails.getAula());
                    horario.setGrupo(horarioDetails.getGrupo());
                    horario.setPeriodoAcademico(horarioDetails.getPeriodoAcademico());
                    horario.setFechaInicio(horarioDetails.getFechaInicio());
                    horario.setFechaFin(horarioDetails.getFechaFin());
                    return ResponseEntity.ok(horarioRepository.save(horario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        if (horarioRepository.existsById(id)) {
            horarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}