package com.practica.hoteles.Dtos;

import java.math.BigDecimal;

public interface habPorRangoPrecio {
    String getHotel();        // AS hotel
    String getTipo();         // AS tipo
    Integer getCapacidad();   // AS capacidad
    Integer getPiso();        // AS piso
    String getNumero();       // AS numero
    BigDecimal getPrecio();   // AS precio
}
