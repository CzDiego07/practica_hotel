package com.practica.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.hoteles.Dtos.habLibrePorHotel;
import com.practica.hoteles.models.Hoteles;

public interface hotelRepository extends JpaRepository<Hoteles, Integer> {
    // Para la consulta de cuantos habitaciones estan libres por hotel.
    // El inner Join corresponde al nombre de la tabla Hotel ("hotel") definida en
    // el archivo Habitaciones.java
    @Query("SELECT " +
            "h.nombre AS hotel, COUNT(ha.id_habitacion) AS habitacionesDisponibles " +
            "FROM Hoteles h " +
            "JOIN h.habitaciones ha " +
            "WHERE ha.estado = com.practica.hoteles.models.Enum_EstadoHab.Disponible " +
            "GROUP BY h.id_hotel, h.nombre")
    List<habLibrePorHotel> contarHabLibrePorHotel();
}
