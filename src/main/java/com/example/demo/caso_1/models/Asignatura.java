package com.example.demo.caso_1.models;

import java.util.HashMap;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "prerrequisitos", joinColumns = @JoinColumn(name = "asignatura_id"))
    @MapKeyColumn(name = "clave")
    @Column(name = "valor")
    private HashMap<String, String> prerrequisitos;

    @ElementCollection
    @CollectionTable(name = "correquisitos", joinColumns = @JoinColumn(name = "asignatura_id"))
    @MapKeyColumn(name = "clave")
    @Column(name = "valor")
    private HashMap<String, String> correquisitos;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String creditos;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
}
