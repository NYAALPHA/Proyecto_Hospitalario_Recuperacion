package com.elsilencio.Trabajador;

import com.elsilencio.Persona.personaDTO;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class trabajadorDTO extends personaDTO {
    private BigDecimal sueldo;
    private String acceso;
    private String login;
    private String password; // Se suele ocultar en GET, pero se usa en POST para crear
    private trabajadorEstadoEnum estado;
}