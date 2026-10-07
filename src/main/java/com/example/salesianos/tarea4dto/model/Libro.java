package com.example.salesianos.tarea4dto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    private String isbn;

    private Integer anioPublicacion;

    private Integer numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
