package com.elsilencio.Pago;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class pagoDTO {
    private Integer idpago;
    private Integer idreserva; // Referencia simple
    private pagoTipoEnum tipoComprobante;
    private String numComprobante;
    private BigDecimal igv;
    private BigDecimal totalPago;
    private LocalDate fechaEmision;
    private LocalDate fechaPago;
}