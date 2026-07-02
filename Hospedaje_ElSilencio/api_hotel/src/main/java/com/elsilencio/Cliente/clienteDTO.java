package com.elsilencio.Cliente;

import com.elsilencio.Persona.personaDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class clienteDTO extends personaDTO {
    private String codigoCliente;
}
