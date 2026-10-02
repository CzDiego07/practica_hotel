package com.practica.hoteles.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Habitaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitaciones {
    //Datos de la tabla columnas
    //ID con Autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habitacion;

    //Varchar 50
    @Column(name = "numero", nullable = false, length = 50)
    private String numero;

    //Integer, no se define columna
    @Column(name = "piso", nullable = false)
    private Integer piso;

    //Estado, se hace uso ENUM para datos ya definidos.(Disponible, Mantenimiento)
    //En Columna no se declara tipo, con Enumerated se define
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Enum_EstadoHab estado;

    // Laves foraneas
    //Relacion Hotel M:N  Habitaciones
    //Un hotel puede tener muchas habitaciones
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hoteles hotel;

    //Relacion Tipo M:N Habitaciones
    //Una habitacion puede tener un tipo, pero un puede existir mas de una habitación con el mismo tipo
    @ManyToOne
    @JoinColumn(name ="id_tipo")
    private Tipo_Habitacion tipo;

}
