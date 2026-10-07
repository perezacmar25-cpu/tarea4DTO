package com.example.salesianos.tarea4dto.dto;

import com.example.salesianos.tarea4dto.model.Autor;
import com.example.salesianos.tarea4dto.model.Libro;

public record EditLibroDTO(
        Long id,
        String titulo,
        String isbn,
        int anioPublicacion,
        int numeroPaginas,
        String autor
) {


    public static EditLibroDTO of(Libro libro) {
        String nombreCompleto = null;
        if (libro.getAutor() != null) {
            nombreCompleto = libro.getAutor().getNombre();

        }

        return new EditLibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getAnioPublicacion(),
                libro.getNumeroPaginas(),
                nombreCompleto
        );
    }


    public Libro to(Autor autor){
        return Libro.builder()
                .id(id)
                .titulo(titulo)
                .isbn(isbn)
                .anioPublicacion(anioPublicacion)
                .numeroPaginas(numeroPaginas)
                .autor(autor)
                .build();
    }
}
