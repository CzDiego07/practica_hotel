package com.practica.hoteles.models;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Tipo_Habitacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// To String pero ignora la variable habitaciones
@ToString(exclude = "habitaciones")
public class Tipo_Habitacion {
    // Datos de la tabla Columnas}
    // Id con Autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo;

    //Varchar 100
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    //Integer, no se declara tamaño
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    //Tipo Text se define en columnDefinition
    @Column(name = "descripcion", nullable = false, columnDefinition = "text")
    private String descripcion;

    //DECIMAL Rango maximo de 99,999,999.99(99.9M - 10,2) (8 Digitos 2 decimales)
    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_base;

    //Relacion Tipo Habitacion N:M Habitaciones
    //Se puede tener Un tipo de habitacion, pero se tienen muchas habitaciones del mismo tipo
    //JSONIGNORE para evitar bucles
    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private List<Habitaciones> habitaciones;

}
