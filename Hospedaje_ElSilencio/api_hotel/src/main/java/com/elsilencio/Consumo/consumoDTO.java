package com.elsilencio.Consumo;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class consumoDTO {
    private Integer idconsumo;
    private Integer idreserva;
    private Integer idproducto;
    private BigDecimal cantidad;
    private BigDecimal precioVenta;
    private consumoEstadoEnum estado;
}
