package com.elsilencio.Persona;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class personaDTO {
    private Integer idpersona;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 20, message = "El nombre no debe superar los 20 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String apaterno;

    @NotBlank(message = "El apellido paterno es obligatorio")
    private String amaterno;

    @NotNull(message = "Debe seleccionar un tipo de documento")
    private personaTipoDocumentoEnum tipoDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    @Pattern(regexp = "^[0-9]+$", message = "El documento solo debe contener números")
    private String numDocumento;

    @NotNull(message = "El género es obligatorio")
    private personaGeneroEnum genero;

    private String direccion;

    @Size(min = 9, max = 15, message = "El teléfono debe tener entre 9 y 15 dígitos")
    private String telefono;

    @Email(message = "El formato del correo electrónico no es válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;
}
