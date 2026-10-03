package com.practica.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.hoteles.models.Habitaciones;

public interface habitacionRepository extends JpaRepository<Habitaciones, Integer> {

}
