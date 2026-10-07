package com.example.salesianos.tarea4dto;

import com.example.salesianos.tarea4dto.dto.LibroDTO;
import com.example.salesianos.tarea4dto.dto.ReservaDTO;
import com.example.salesianos.tarea4dto.dto.SerieDTO;
import com.example.salesianos.tarea4dto.model.*;

import java.util.Arrays;
import java.util.List;

public class Main {


    //Generado por IA
    public static void main(String[] args) {
        probarLibros();
        System.out.println();
        probarReservas();
        System.out.println();
        probarSeries();
    }

    private static void probarLibros() {
        System.out.println("===== LIBROS =====");

        Autor autorCompleto = Autor.builder()
                .id(1L).nombre("Gabriel").apellido1("García").apellido2("Márquez")
                .nacionalidad("Colombiana").build();

        Autor autorSinApellido2 = Autor.builder()
                .id(2L).nombre("Stephen").apellido1("King")
                .nacionalidad("Estadounidense").build();

        Libro l1 = Libro.builder().id(1L).titulo("Cien años de soledad").isbn("978-0307474728")
                .anioPublicacion(1967).numeroPaginas(471).autor(autorCompleto).build();

        Libro l2 = Libro.builder().id(2L).titulo("It").isbn("978-1501142970")
                .anioPublicacion(1986).numeroPaginas(1138).autor(autorSinApellido2).build();

        Libro l3 = Libro.builder().id(3L).titulo("Libro anónimo").isbn("000-0000000000")
                .anioPublicacion(1500).numeroPaginas(200).build(); // sin autor

        Libro l4 = null;

        System.out.println(LibroDTO.of(l1));
        System.out.println(LibroDTO.of(l2));
        System.out.println(LibroDTO.of(l3));
        System.out.println(LibroDTO.of(l4));
    }

    private static void probarReservas() {
        System.out.println("===== RESERVAS =====");

        Cliente cliente = Cliente.builder()
                .id(1L).nombre("Ana").apellidos("López Ruiz")
                .email("ana@correo.com").telefono("600123456").build();

        Habitacion habitacion = Habitacion.builder()
                .id(1L).numero("101").tipo("Doble").precioNoche(80.0).planta(1).build();

        Reserva r1 = Reserva.builder().id(1L).codigo("R-001").numeroNoches(3)
                .cliente(cliente).habitacion(habitacion).build();

        Reserva r2 = Reserva.builder().id(2L).codigo("R-002").numeroNoches(2)
                .habitacion(habitacion).build(); // sin cliente

        Reserva r3 = Reserva.builder().id(3L).codigo("R-003").numeroNoches(1)
                .cliente(cliente).build(); // sin habitación

        Reserva r4 = Reserva.builder().id(4L).codigo("R-004").build(); // casi vacía

        Reserva r5 = null;

        System.out.println(ReservaDTO.of(r1));
        System.out.println(ReservaDTO.of(r2));
        System.out.println(ReservaDTO.of(r3));
        System.out.println(ReservaDTO.of(r4));
        System.out.println(ReservaDTO.of(r5));
    }

    private static void probarSeries() {
        System.out.println("===== SERIES =====");

        Creador vince = Creador.builder()
                .id(1L).nombre("Vince").apellidos("Gilligan").pais("EEUU").build();

        Creador baran = Creador.builder()
                .id(2L).nombre("Baran").apellidos("bo Odar").pais("Alemania").build();

        Creador soloNombre = Creador.builder()
                .id(3L).nombre("Pedro").pais("España").build(); // sin apellidos

        Categoria drama = Categoria.builder()
                .id(1L).nombre("Drama").descripcion("Series dramáticas").build();

        Categoria scifi = Categoria.builder()
                .id(2L).nombre("Ciencia ficción").descripcion("Series de ciencia ficción").build();

        Categoria sinNombre = Categoria.builder()
                .id(3L).descripcion("Categoría sin nombre").build();

        // 1. Serie completa
        Serie s1 = Serie.builder().id(1L).titulo("Breaking Bad")
                .sinopsis("Un profesor de química...").numeroTemporadas(5)
                .creador(vince).categoria(drama)
                .imagenes(List.of("bb1.jpg", "bb2.jpg")).build();

        // 2. Imágenes con basura al principio (null, vacía, solo espacios)
        Serie s2 = Serie.builder().id(2L).titulo("Dark").numeroTemporadas(3)
                .creador(baran).categoria(scifi)
                .imagenes(Arrays.asList(null, "", "   ", "dark.jpg")).build();

        // 3. Serie sin creador, sin categoría y con lista de imágenes vacía (por defecto)
        Serie s3 = Serie.builder().id(3L).titulo("Serie sin datos").build();

        // 4. Creador sin apellidos, categoría sin nombre e imágenes = null
        Serie s4 = Serie.builder().id(4L).titulo("Serie sin imágenes").numeroTemporadas(2)
                .creador(soloNombre).categoria(sinNombre)
                .imagenes(null).build();

        // 5. Serie null
        Serie s5 = null;

        System.out.println(SerieDTO.of(s1));
        System.out.println(SerieDTO.of(s2));
        System.out.println(SerieDTO.of(s3));
        System.out.println(SerieDTO.of(s4));
        System.out.println(SerieDTO.of(s5));
    }
}