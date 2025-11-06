package com.example.demo.caso_1.controllers;

import com.example.demo.caso_1.models.Estudiante;
import com.example.demo.caso_1.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteDetails.getNombre());
                    estudiante.setApellido(estudianteDetails.getApellido());
                    estudiante.setCodigo(estudianteDetails.getCodigo());
                    estudiante.setCorreo(estudianteDetails.getCorreo());
                    estudiante.setTelefono(estudianteDetails.getTelefono());
                    estudiante.setPromedio(estudianteDetails.getPromedio());
                    estudiante.setAsignaturas(estudianteDetails.getAsignaturas());
                    estudiante.setInscripcion(estudianteDetails.getInscripcion());
                    estudiante.setInicioEstudios(estudianteDetails.getInicioEstudios());
                    estudiante.setCarrera(estudianteDetails.getCarrera());
                    return ResponseEntity.ok(estudianteRepository.save(estudiante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}