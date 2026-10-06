package com.practica.hoteles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.cantidadTiposHab;
import com.practica.hoteles.Dtos.habCapacidad;
import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habPrecio;
import com.practica.hoteles.Dtos.habPrecioPromedioPorHotel;
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
        return (List<Habitaciones>) habitacionJPA.findByEstado(Enum_EstadoHab.Disponible); // Se puede cambiar por
                                                                                           // Disponible o
                                                                                           // Mantenimiento(1 a la vez)
    }

    // Consulta 8. Precio de habitaciones para X personas
    // Cambio de PathVariable a RequestParam.
    @GetMapping("/capacidad")
    public List<habCapacidad> obtenerHabitacionPorCapacidad(@RequestParam Integer cantidad) {
        return habitacionJPA.obtenerPrecioPorCapacidad(cantidad);
    }

    // Consulta 13. ¿Cual es el precio promedio de una habitacion en cada hotel?
    // Obtener precio promedio de las habitaciones segun cada hotel
    @GetMapping("/precio/promedio")
    public List<habPrecioPromedioPorHotel> obtenerPrecioPromedioPorHotel() {
        return habitacionJPA.obtenerPrecioPromedioPorHotel();
    }

    // Consutla 14. ¿Cual es la habitacion con precio mas bajo por hotel?
    @GetMapping ("precio/minimo")
    public List<habPrecio> obtenerHabPrecioMinimo(){
        return  habitacionJPA.obtenerHabPrecioBajo();
    }
    // Consulta 15. ¿Cual es la habitacion con precio mas alto por hotel?
    @GetMapping ("precio/maximo")
    public  List <habPrecio> obtenerHabPrecioMaximo(){
        return habitacionJPA.obtenerHabPrecioAlto();
    }

    // Consulta 16. ¿Cuantas habitaciones se tiene por tipo en cada hotel?
    @GetMapping("tipo/cantidad")
    public  List <cantidadTiposHab> obtenerCantidadPorTipo(){
        return  habitacionJPA.obtenerCantidadTiposPorHotel();
    }

    // Consulta 17. ¿Que habitaciones se encuentran en un piso en especifico ?
    @GetMapping ("piso/{numero}")
    public List<Habitaciones> obtenerHabitacionesPorPiso(@PathVariable Integer numero){
        return  habitacionJPA.findByPiso(numero);
    }
}
