package com.crediya.autenticacion.infrastructure.entry_points.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UsuarioRequest(
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        String direccion,
        String telefono,
        String correoElectronico,
        BigDecimal salarioBase
) {}
