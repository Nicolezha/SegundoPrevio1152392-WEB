package com.example.demo.caso_1.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ajustes")
public class Ajustes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "periodo_academico_id")
    private PeriodoAcademico periodoAcademico;

    @Enumerated(EnumType.STRING)
    private Cancelacion cancelacion;

    @Column(name = "fecha_limite")
    private LocalDate fechaLimite;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiantes;

    public void agregarAsignatura(Asignatura asignatura) {
        // Logica
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        // Logica
    }
}
