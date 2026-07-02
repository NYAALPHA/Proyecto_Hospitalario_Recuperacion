package com.elsilencio.Consumo;

import java.math.BigDecimal;

import com.elsilencio.Producto.productoEntity;
import com.elsilencio.Reserva.reservaEntity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "consumo")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class consumoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idconsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idreserva", nullable = false)
    private reservaEntity reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproducto", nullable = false)
    private productoEntity producto;

    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal cantidad;

    @Column(name = "precio_venta", precision = 7, scale = 2, nullable = false)
    private BigDecimal precioVenta;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private consumoEstadoEnum estado;
}
