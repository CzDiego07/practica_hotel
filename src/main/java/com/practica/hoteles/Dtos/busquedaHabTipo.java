package com.practica.hoteles.Dtos;

import java.math.BigDecimal;

public interface busquedaHabTipo {
    String getHotel();        // AS hotel
    String getHabitacion();   // AS habitacion
    String getTipo();         // AS tipo
    BigDecimal getPrecio();   // AS precio
}
