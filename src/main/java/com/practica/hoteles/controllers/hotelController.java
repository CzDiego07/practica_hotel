package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //Consulta 3. ¿?

}
