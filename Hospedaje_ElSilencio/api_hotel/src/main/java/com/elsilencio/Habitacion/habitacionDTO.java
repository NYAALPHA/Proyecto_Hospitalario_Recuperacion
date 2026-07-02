package com.elsilencio.Habitacion;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class habitacionDTO {
    private Integer idhabitacion;
    private String numero;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private BigDecimal precioDiario;
    private habitacionEstadoEnum estado;
    private habitacionTipoEnum tipoHabitacion;
}