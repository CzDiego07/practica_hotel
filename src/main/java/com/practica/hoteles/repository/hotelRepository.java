package com.practica.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.hoteles.models.Hoteles;

public interface hotelRepository extends JpaRepository<Hoteles, Integer> {

}
