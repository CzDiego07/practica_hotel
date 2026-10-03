package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habTipoPrecio;
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

    //Consulta 3. ¿Cuales son los tipos de cada habitacion y su precio base?
    @GetMapping("/tipos/precio")
    public List<habTipoPrecio> obtenerTipoPrecio(){
        return habitacionJPA.obtenerHotelHabTipoPrecio();
    }
}
