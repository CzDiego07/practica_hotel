package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.habLibrePorHotel;
import com.practica.hoteles.Dtos.habManPorHotel;
import com.practica.hoteles.Dtos.habTotalPorHotel;
import com.practica.hoteles.models.Hoteles;
import com.practica.hoteles.repository.hotelRepository;

@RestController
@RequestMapping("/api/hotel/hoteles")
public class hotelController {

    @Autowired
    private hotelRepository hotelJPA;

    public hotelController(hotelRepository hotelJPA) {
        this.hotelJPA = hotelJPA;
    }

    // Consulta 1. ¿Qué hoteles estan registrados?
    @GetMapping
    public List<Hoteles> obtenerHoteles() {
        return (List<Hoteles>) hotelJPA.findAll();
    }

    // Consulta 5. ¿Cuantas habitaciones estan disponibles en cada hotel?
    @GetMapping("/habitaciones/libres")
    public List<habLibrePorHotel> obtenerHabLibres() {
        return hotelJPA.contarHabLibrePorHotel();
    }

    // Consulta 6. ¿Cuantas habitaciones disponibles tiene un hotel en especifico?
    @GetMapping("/habitaciones/libres/{id}")
    public List<habLibrePorHotel> obtenerHabLibresPorID(@PathVariable Integer id) {
        return hotelJPA.contarHabLibrePorHotel(id);
    }

    // Consulta 7. ¿Cuantas habitaciones tiene cada hotel?
    @GetMapping("/habitaciones/total")
    public List<habTotalPorHotel> obtenerTotalHabHotel() {
        return hotelJPA.contarHabTotalHotel();
    }

    // Consulta 10. ¿Cuantas habitaciones estan en mantenimiento en cada hotel?
    @GetMapping("/habitaciones/mantenimiento")
    public List<habManPorHotel> obtenerHabManPorHotel() {
        return hotelJPA.contarHabMantenimeitnoPorHotel();
    }
}
