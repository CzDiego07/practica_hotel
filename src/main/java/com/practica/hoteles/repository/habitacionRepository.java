package com.practica.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habTipoPrecio;
import com.practica.hoteles.models.Habitaciones;

public interface habitacionRepository extends JpaRepository<Habitaciones, Integer> {

    //Creamos la consulta para saber habitacion por Hotel y estado actual
    @Query("SELECT " +
    "h.nombre AS hotel, ha.numero AS habitacion, ha.piso AS piso, ha.estado AS estado" +
            " FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h")
    List<habPorHotelEstado> obtenerHabitacionesPorHotel();

    //Crear la consulta para tener los datos de Hotel, habitacion, tipo, capacidad, precio. 3 Tablas, Hotel, Tipo y Habitacion
    @Query("SELECT "+
        "h.nombre AS hotel, ha.numero AS habitacion, t.nombre AS tipo,t.capacidad AS capacidad, t.precio_base AS precio "+
        "FROM Habitaciones ha "+
        "INNER JOIN ha.hotel h "+
        "INNER JOIN ha.tipo t"
    )
    List<habTipoPrecio> obtenerHotelHabTipoPrecio();
}
