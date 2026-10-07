package com.practica.hoteles.Dtos;

import java.math.BigDecimal;

public interface habEstadoPorPiso {
    String getHotel();        // AS hotel
    String getHabitacion();   // AS habitacion
    Integer getPiso();        // AS piso
    String getTipo();         // AS tipo
    BigDecimal getPrecio();   // AS precio
}
