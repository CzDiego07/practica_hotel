package com.practica.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practica.hoteles.Dtos.habCapacidad;
import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habPrecioPromedioPorHotel;
import com.practica.hoteles.Dtos.habTipoPrecio;
import com.practica.hoteles.models.Enum_EstadoHab;
import com.practica.hoteles.models.Habitaciones;

public interface habitacionRepository extends JpaRepository<Habitaciones, Integer> {

    // Creamos la consulta para saber habitacion por Hotel y estado actual
    // El inner Join Corresponde a como se nombro el la tabla con relacion ManyToOne
    // Para el caso de hoteles (private Hoteles hotel)
    @Query("SELECT " +
            "h.nombre AS hotel, ha.numero AS habitacion, ha.piso AS piso, ha.estado AS estado" +
            " FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h")
    List<habPorHotelEstado> obtenerHabitacionesPorHotel();

    // Crear la consulta para tener los datos de Hotel, habitacion, tipo, capacidad,
    // precio. 3 Tablas, Hotel, Tipo y Habitacion
    // El inner Join corresponde a como se nombra la relacion de cada tabla
    // ManyToOne, en el caso de Tipo_habitacion se representa como tipo
    // (private Tipo_Habitacion tipo)
    @Query("SELECT " +
            "h.nombre AS hotel, ha.numero AS habitacion, t.nombre AS tipo,t.capacidad AS capacidad, t.precio_base AS precio "
            +
            "FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h " +
            "INNER JOIN ha.tipo t")
    List<habTipoPrecio> obtenerHotelHabTipoPrecio();

    // Buscar habitaciones segun por el estado(Disponible/Mantenimiento)
    public List<Habitaciones> findByEstado(Enum_EstadoHab estado);

    // Consulta 8. Obtener precios de Hotel, Habitacion, piso, numero para una
    // cantidad de gente especifica o mayor. Ordenados primero los de la misma
    // capacidad y despues los mayores.
    @Query("SELECT " +
            "h.nombre AS hotel, t.capacidad AS capacidad, t.precio_base AS precio, ha.numero AS numero, ha.piso AS piso "
            +
            "FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h " +
            "INNER JOIN ha.tipo t " +
            "WHERE t.capacidad >= :capacidad " +
            "ORDER BY t.capacidad ASC")
    public List<habCapacidad> obtenerPrecioPorCapacidad(@Param("capacidad") Integer capacidad);

    //Consulta 13. Obtener el precio promedio de habitaciones por Hotel
    // Funcion para calcular el promedio de los precios de habitacion por Hotel
    // Debe devolver los datos del hotel, cantidad de habitaciones, promedio en
    // precio por hotel
    // Datos: Nombre AS Hotel, Cantidad de habitaciones, Precio promedio en total
    @Query("SELECT " +
            "h.nombre AS hotel, " +
            "COUNT(ha) AS cantidad, " +
            "AVG(t.precio_base) AS promedio " +
            "FROM Habitaciones ha " +
            "INNER JOIN ha.hotel h " +
            "INNER JOIN ha.tipo t " +
            "GROUP BY h.id_hotel, h.nombre")
    public List<habPrecioPromedioPorHotel> obtenerPrecioPromedioPorHotel();
}
