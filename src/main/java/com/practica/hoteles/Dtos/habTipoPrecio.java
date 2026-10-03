package com.practica.hoteles.Dtos;

import java.math.BigDecimal;

public interface habTipoPrecio {
    String getHotel();
    Integer getHabitacion();
    String getTipo();
    Integer getCapacidad();
    BigDecimal getPrecio();
}
