package com.practica.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.hoteles.models.Tipo_Habitacion;

public interface tipoHabRepository extends JpaRepository<Tipo_Habitacion, Integer> {

}
