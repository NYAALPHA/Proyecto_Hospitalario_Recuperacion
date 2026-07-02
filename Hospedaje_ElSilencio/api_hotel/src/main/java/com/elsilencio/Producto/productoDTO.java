package com.elsilencio.Producto;

import lombok.*;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class productoDTO {
    private Integer idproducto;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;

    @NotNull(message = "El precio de venta es obligatorio")
    @Positive(message = "El precio debe ser un valor mayor a cero")
    private BigDecimal precioVenta;

    @NotNull(message = "La unidad de medida es obligatoria")
    private productoMedidaEnum unidadMedida;

    private String descripcion;
}