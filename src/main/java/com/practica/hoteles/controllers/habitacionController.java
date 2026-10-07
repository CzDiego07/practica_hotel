package com.practica.hoteles.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hoteles.Dtos.busquedaHabTipo;
import com.practica.hoteles.Dtos.cantidadTiposHab;
import com.practica.hoteles.Dtos.capacidadMaxHotel;
import com.practica.hoteles.Dtos.habCapacidad;
import com.practica.hoteles.Dtos.habEstadoPorPiso;
import com.practica.hoteles.Dtos.habPorHotelEstado;
import com.practica.hoteles.Dtos.habPorPisoExtremo;
import com.practica.hoteles.Dtos.habPorRangoPrecio;
import com.practica.hoteles.Dtos.habPrecio;
import com.practica.hoteles.Dtos.habPrecioPromedioPorHotel;
import com.practica.hoteles.Dtos.habTipoPrecio;
import com.practica.hoteles.Dtos.habTiposPorHotel;
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

    // Consulta 4. ¿Qué habitaciones están disponibles? 
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
    @GetMapping("precio/minimo")
    public List<habPrecio> obtenerHabPrecioMinimo() {
        return habitacionJPA.obtenerHabPrecioBajo();
    }

    // Consulta 15. ¿Cual es la habitacion con precio mas alto por hotel?
    @GetMapping("precio/maximo")
    public List<habPrecio> obtenerHabPrecioMaximo() {
        return habitacionJPA.obtenerHabPrecioAlto();
    }

    // Consulta 16. ¿Cuantas habitaciones se tiene por tipo en cada hotel?
    @GetMapping("tipo/cantidad")
    public List<cantidadTiposHab> obtenerCantidadPorTipo() {
        return habitacionJPA.obtenerCantidadTiposPorHotel();
    }

    // Consulta 17. ¿Que habitaciones se encuentran en un piso en especifico ?
    @GetMapping("piso/{numero}")
    public List<Habitaciones> obtenerHabitacionesPorPiso(@PathVariable Integer numero) {
        return habitacionJPA.findByPiso(numero);
    }

    // Consulta 18. ¿Que tipos de habitaciones se tienen en cada hotel?
    @GetMapping("tipos/hotel")
    public List<habTiposPorHotel> obtenerTiposPorHotel() {
        return habitacionJPA.obtenerTiposHabitacionPorHotel();
    }

    // Consulta 21. ¿Cual es la capacidad maxima por hotel?
    @GetMapping("capacidad/maxima")
    public List<capacidadMaxHotel> obtenerCapacidadMaxima() {
        return habitacionJPA.obtenerCapacidadMaxima();
    }

    // Consulta 22. ¿Que habitaciones pertencen a un tipo especifico?
    @GetMapping("busqueda/tipo")
    public List<busquedaHabTipo> busquedaPorTipo(@RequestParam String tipo) {
        return habitacionJPA.buscarHabPorTipo(tipo);
    }

    // Consulta 23. ¿Qué habitaciones se encuentran en el piso más alto?
    @GetMapping("/piso/maximo")
    public List<habPorPisoExtremo> obtenerHabitacionesPisoMasAlto() {
        return habitacionJPA.obtenerHabitacionesPisoMasAlto();
    }

    // Consulta 24. ¿Qué habitaciones se encuentran en el piso más bajo?
    @GetMapping("/piso/minimo")
    public List<habPorPisoExtremo> obtenerHabitacionesPisoMasBajo() {
        return habitacionJPA.obtenerHabitacionesPisoMasBajo();
    }

    // Consulta 25. ¿Que habitaciones estan en mantenimiento?
    @GetMapping("/mantenimiento")
    public List<Habitaciones> obtenerMantenimiento() {
        return (List<Habitaciones>) habitacionJPA.findByEstado(Enum_EstadoHab.Mantenimiento); // Se puede cambiar por
                                                                                              // Disponible o
                                                                                              // Mantenimiento(1 a la
                                                                                              // vez)
    }

    // Consulta 26. ¿Que habitaciones estan ocupadas?
    @GetMapping("/ocupadas")
    public List<Habitaciones> obtenerOcupadas() {
        return (List<Habitaciones>) habitacionJPA.findByEstado(Enum_EstadoHab.Ocupado); // Se puede cambiar por
                                                                                        // Disponible o
                                                                                        // Mantenimiento(1 a la vez)
    }

    // Consulta 27. ¿Que habitaciones estan disponibles en un piso X?
    @GetMapping("/disponibles/{piso}")
    public List<habEstadoPorPiso> obtenerHabEstadoPorPisoLibres(@PathVariable Integer piso){
        return  habitacionJPA.obtenerDisponiblesPorPiso(Enum_EstadoHab.Disponible, piso);
    }
    
     // Consulta 28. ¿Que habitaciones estan mantenimiento en un piso X?
    @GetMapping("/mantenimiento/{piso}")
    public List<habEstadoPorPiso> obtenerHabEstadoPorPisoMantenimiento(@PathVariable Integer piso){
        return  habitacionJPA.obtenerDisponiblesPorPiso(Enum_EstadoHab.Mantenimiento, piso);
    }

     // Consulta 29. ¿Que habitaciones estan ocupadas en un piso X?
    @GetMapping("/ocupadas/{piso}")
    public List<habEstadoPorPiso> obtenerHabEstadoPorPisoOcupado(@PathVariable Integer piso){
        return  habitacionJPA.obtenerDisponiblesPorPiso(Enum_EstadoHab.Ocupado, piso);
    }

    // Consulta 30. Habitaciones por rango de precio
    @GetMapping("/precio/rango")
    public List<habPorRangoPrecio> obtenerPorRangoPrecio(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return habitacionJPA.obtenerHabitacionesPorRangoPrecio(min, max);
    }
}
