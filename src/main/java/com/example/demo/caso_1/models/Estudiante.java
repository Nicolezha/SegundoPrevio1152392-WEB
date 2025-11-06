package com.example.demo.caso_1.models;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    private Double promedio;

    @ManyToMany
    @JoinTable(name = "estudiante_asignatura",
               joinColumns = @JoinColumn(name = "estudiante_id"),
               inverseJoinColumns = @JoinColumn(name = "asignatura_id"))
    private List<Asignatura> asignaturas;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private Inscripcion inscripcion;

    private Date inicioEstudios;

    @Enumerated(EnumType.STRING)
    private Carrera carrera;

  
}
