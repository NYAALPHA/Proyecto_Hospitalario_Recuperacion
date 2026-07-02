package com.elsilencio.Reserva;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class reservaDTO {
    private Integer idreserva;
    private Integer idhabitacion;
    private Integer idcliente;
    private Integer idtrabajador;
    private reservaTipoEnum tipoReserva;
    private LocalDate fechaReserva;
    private LocalDate fechaIngresa;
    private LocalDate fechaSalida;
    private BigDecimal costoAlojamiento;
    private reservaTipoEnum estado;
}