package com.practica.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.models.Habitaciones;

public interface habitacionRepository extends JpaRepository<Habitaciones, Integer> {

    //Creamos la consulta para saber habitacion por Hotel y estado actual
    @Query("SELECT " +
    "h.nombre AS hotel, ha.numero AS habitacion, ha.piso AS piso, ha.estado AS estado" +
            " FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h")
    List<habPorHotelEstado> obtenerHabitacionesPorHotel();

}
