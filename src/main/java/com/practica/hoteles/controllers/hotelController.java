package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.habConteoEstadoPorHotel;
import com.practica.hoteles.Dtos.habTotalPorHotel;
import com.practica.hoteles.models.Enum_EstadoHab;
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

    // Cambios en consultas 5, 6 y 10. 
    // Se refactorizo la funcion de conteo de Hoteles Segun Estado y en un hotel especifico.
    // Se hace uso de dos funciones con el mismo nombre
    // Se definieron dos parametros: Enum estado, Integer id
    // Solo estado hace la consulta para todos los hoteles pero cuenta unicamente el estado indicado
    // Al agregar ID, se enfoca unicamente en el hotel seleccionado
    // Consulta 5. ¿Cuantas habitaciones estan disponibles en cada hotel?
    @GetMapping("/habitaciones/libres")
    public List<habConteoEstadoPorHotel> obtenerHabLibres() {
        return hotelJPA.contarHabEstadoXPorHotel(Enum_EstadoHab.Disponible); // Solo habitaciones Disponibles
    }

    // Consulta 6. ¿Cuantas habitaciones disponibles tiene un hotel en especifico?
    @GetMapping("/habitaciones/libres/{id}")
    public List<habConteoEstadoPorHotel> obtenerHabLibresPorID(@PathVariable Integer id) {
        return hotelJPA.contarHabEstadoXPorHotel(Enum_EstadoHab.Disponible, id); // Habitaciones Disponibles y en Hotel
                                                                                 // especifico
    }

    // Consulta 7. ¿Cuantas habitaciones tiene cada hotel?
    @GetMapping("/habitaciones/total")
    public List<habTotalPorHotel> obtenerTotalHabHotel() {
        return hotelJPA.contarHabTotalHotel();
    }

    // Consulta 10. ¿Cuantas habitaciones estan en mantenimiento en cada hotel?
    @GetMapping("/habitaciones/mantenimiento")
    public List<habConteoEstadoPorHotel> obtenerHabManPorHotel() {
        return hotelJPA.contarHabEstadoXPorHotel(Enum_EstadoHab.Mantenimiento); // Unicamente cuenta habitaciones en
                                                                                // especifico
    }
}
