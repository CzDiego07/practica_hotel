package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.models.Tipo_Habitacion;
import com.practica.hoteles.repository.tipoHabRepository;

@RestController
@RequestMapping("/api/tipo/habitacion")
public class tipoHabController {
    @Autowired
    private tipoHabRepository tipoJPA;

    public tipoHabController(tipoHabRepository tipoJPA) {
        this.tipoJPA = tipoJPA;
    }

    // Consulta 9. ¿Que tipos de habitaciones se tienen registrados?
    @GetMapping
    public List<Tipo_Habitacion> obtenerTipos() {
        return (List<Tipo_Habitacion>) tipoJPA.findAll();
    }

}
