package com.practica.hoteles.Dtos;

import com.practica.hoteles.models.Enum_EstadoHab;

public interface habPorHotelEstado {
    //Los get deben coincidir con el alias de la consulta
    
    String getHotel(); //AS hotel -> getHotel()
    String getHabitacion(); // AS habitacion -> getHabitacion()
    Integer getPiso(); // AS piso ha.piso -> getPiso()
    Enum_EstadoHab getEstado(); // AS estado ha.estado -> getEstado()
}
