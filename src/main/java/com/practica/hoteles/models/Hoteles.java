package com.practica.hoteles.models;

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
@Table(name = "Hoteles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//To String para impresion pero ignora la variable habitaciones
@ToString(exclude = "habitaciones")
public class Hoteles {
    //Datos de la tabla Columnas
    //Id con Autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hotel;

    //Varchar 100
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    //Varchar 255
    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    //Varchar 100
    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    //Varchar 50
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    //Varchar 100
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    //Booelano
    @Column(name = "activo", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean activo;

    // Relacion de Hoteles N:M Habitaciones
    //Un Hotel puede tener muchas habitaciones
    //JSONIGNORE para evitar bucles infinitos
    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private List<Habitaciones> habitaciones;
}
