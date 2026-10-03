package com.practica.hoteles.Dtos;

import java.math.BigDecimal;

public interface habTipoPrecio {
    String getHotel(); // AS hotel ->getHotel()
    Integer getHabitacion(); //AS habitacion -> getHabitacion()
    String getTipo(); //AS tipo -> getTipo()
    BigDecimal getPrecio(); //AS capacidad -> getPrecio()
}
