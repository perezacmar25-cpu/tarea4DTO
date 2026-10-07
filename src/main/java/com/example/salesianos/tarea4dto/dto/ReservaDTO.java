package com.example.salesianos.tarea4dto.dto;

import com.example.salesianos.tarea4dto.model.Cliente;
import com.example.salesianos.tarea4dto.model.Habitacion;
import com.example.salesianos.tarea4dto.model.Reserva;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDTO of(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        return new ReservaDTO(
                reserva.getCodigo(),
                nombreCliente(reserva.getCliente()),
                descripcionHabitacion(reserva.getHabitacion()),
                reserva.getNumeroNoches(),
                precioTotal(reserva)
        );
    }

    private static String nombreCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        String nombre = Stream.of(cliente.getNombre(), cliente.getApellidos())
                .filter(s -> s != null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "));

        return nombre.isEmpty() ? null : nombre;
    }

    private static String descripcionHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            return null;
        }
        String desc = Stream.of(habitacion.getNumero(), habitacion.getTipo())
                .filter(s -> s != null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining("-"));

        return desc.isEmpty() ? null : desc;
    }

    private static Double precioTotal(Reserva reserva) {
        Habitacion h = reserva.getHabitacion();
        if (h == null || h.getPrecioNoche() == null || reserva.getNumeroNoches() == null) {
            return null;
        }
        return h.getPrecioNoche() * reserva.getNumeroNoches();
    }
}