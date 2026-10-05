package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habTipoPrecio;
import com.practica.hoteles.models.Enum_EstadoHab;
import com.practica.hoteles.models.Habitaciones;
import com.practica.hoteles.repository.habitacionRepository;

@RestController
@RequestMapping("/api/hotel/habitaciones")
public class habitacionController {

    @Autowired
    private habitacionRepository habitacionJPA;

    public habitacionController(habitacionRepository habitacionJPA) {
        this.habitacionJPA = habitacionJPA;
    }

    // Consulta 2. ¿Qué habitaciones tiene cada hotel y que estado tiene
    // actualmente?
    @GetMapping
    public List<habPorHotelEstado> obtenerHabitacionesPorHotel() {
        return habitacionJPA.obtenerHabitacionesPorHotel();
    }

    // Consulta 3. ¿Cuales son los tipos de cada habitacion y su precio base?
    @GetMapping("/tipos/precio")
    public List<habTipoPrecio> obtenerTipoPrecio() {
        return habitacionJPA.obtenerHotelHabTipoPrecio();
    }

    // Consulta 4. Habitaciones "Disponibles"
    // Nota adicional, al llamar a la entidad "Habitaciones", obtendra todos los
    // datos tanto de habitaciones,como de la entidad "Hotel" al tenerla dentro de
    // la misma
    @GetMapping("/disponibles")
    public List<Habitaciones> obtenerDisponibles() {
        return (List<Habitaciones>) habitacionJPA.findByEstado(Enum_EstadoHab.Disponible); // Se puede cambiar por Disponible o Mantenimiento(1 a la vez)
    }
    
}
