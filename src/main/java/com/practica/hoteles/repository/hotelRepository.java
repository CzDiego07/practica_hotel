package com.practica.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practica.hoteles.Dtos.habConteoEstadoPorHotel;
import com.practica.hoteles.Dtos.habTotalPorHotel;
import com.practica.hoteles.models.Enum_EstadoHab;
import com.practica.hoteles.models.Hoteles;

public interface hotelRepository extends JpaRepository<Hoteles, Integer> {
        // Para la consulta de cuantos habitaciones estan libres por hotel.
        // El inner Join corresponde al nombre de la tabla Hotel ("hotel") definida en
        // el archivo Habitaciones.java
        // Cambio en Commit 16: Refactorizacion
        // Se cambio la consulta SQL para que se pueda llamar la misma funcion pero en
        // el Controller se cambia al estado deseado
        @Query("SELECT " +
                        "h.nombre AS hotel, COUNT(ha.id_habitacion) AS habitacionesEstadoActual " +
                        "FROM Hoteles h " +
                        "JOIN h.habitaciones ha " +
                        "WHERE ha.estado = :estado " +
                        "GROUP BY h.id_hotel, h.nombre")
        List<habConteoEstadoPorHotel> contarHabEstadoXPorHotel(@Param("estado") Enum_EstadoHab estado);

        // Para seleccionar un hotel especifico se menciona una ID en especifico
        // se hace con :id y @Param("id")"
        // Cambio en Commit 16: Refactorizacion
        // Se cambia el where estado por variable, para llamar la misma funcion pero en
        // Controller se puede cambiar a un estado diferente con la misma funcion
        @Query("SELECT " +
                        "h.nombre AS hotel, COUNT(ha.id_habitacion) AS habitacionesEstadoActual " +
                        "FROM Hoteles h " +
                        "JOIN h.habitaciones ha " +
                        "WHERE ha.estado = :estado AND h.id_hotel = :id "
                        +
                        // Se agrega despues del WHERE
                        "GROUP BY h.id_hotel, h.nombre")
        List<habConteoEstadoPorHotel> contarHabEstadoXPorHotel(@Param("estado") Enum_EstadoHab estado,
                        @Param("id") Integer id);

        // Crear la consulta para obtener la cantidad de habitaciones que tiene cada
        // hotel
        @Query("SELECT "
                        + " h.nombre AS hotel, "
                        + "COUNT(ha.id_habitacion) AS total "
                        + "FROM Hoteles h "
                        + "JOIN h.habitaciones ha "
                        + "GROUP BY h.id_hotel, h.nombre")
        List<habTotalPorHotel> contarHabTotalHotel();

}
