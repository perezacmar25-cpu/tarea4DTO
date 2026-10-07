package com.example.salesianos.tarea4dto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String nacionalidad;
}
