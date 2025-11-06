package com.example.demo.caso_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.caso_2.models.Autorizadora;

@Repository
public interface AutorizadoraRepository extends JpaRepository<Autorizadora, Long>{

    
}
