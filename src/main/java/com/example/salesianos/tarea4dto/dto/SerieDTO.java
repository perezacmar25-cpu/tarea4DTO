package com.example.salesianos.tarea4dto.dto;

import com.example.salesianos.tarea4dto.model.Categoria;
import com.example.salesianos.tarea4dto.model.Creador;
import com.example.salesianos.tarea4dto.model.Serie;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {

    public static SerieDTO of(Serie serie){
        if(serie == null)
            return null;

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                nombreCreador(serie.getCreador()),
                nombreCategoria(serie.getCategoria()),
                primeraImagen(serie)



        );
    }

    public static String nombreCreador(Creador creador){
        if (creador==null)
            return null;

        String nombre = Stream.of(creador.getNombre(), creador.getApellidos())
                .filter(s->s!=null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "));

        return nombre.isEmpty() ? null : nombre;
    }

    public static String nombreCategoria(Categoria categoria){

        if(categoria==null)
            return null;

        String nombre = Stream.of(categoria.getNombre())
                .filter(s-> s!=null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining());

        return nombre.isEmpty() ? null : nombre;
    }

    public static String primeraImagen(Serie serie){
        if(serie == null || serie.getImagenes()== null)
            return null;

        return serie.getImagenes().stream()
                .filter(s->s!=null && !s.isBlank())
                .map(String::trim)
                .findFirst()
                .orElse(null);
    }


}
