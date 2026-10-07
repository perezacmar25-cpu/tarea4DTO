package com.example.salesianos.tarea4dto.dto;

import com.example.salesianos.tarea4dto.model.Autor;
import com.example.salesianos.tarea4dto.model.Libro;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO of(Libro libro) {
        if (libro == null) {
            return null;
        }
        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompleto(libro.getAutor()),
                libro.getAnioPublicacion()
        );
    }


    //Ayuda de la IA
    private static String nombreCompleto(Autor autor) {
        if (autor == null) {
            return null;
        }
        String nombre = Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                .filter(s -> s != null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "));

        return nombre.isEmpty() ? null : nombre;
    }
}