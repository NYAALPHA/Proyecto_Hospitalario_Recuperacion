package com.elsilencio.Pago;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elsilencio.Reserva.reservaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "pago")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class pagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;

    // Relación con la Reserva
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idreserva", nullable = false)
    private reservaEntity reserva;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comprobante", length = 20, nullable = false)
    private pagoTipoEnum tipoComprobante;

    @Column(name = "num_comprobante", length = 20, nullable = false)
    private String numComprobante;

    @Column(precision = 4, scale = 2, nullable = false)
    private BigDecimal igv;

    @Column(name = "total_pago", precision = 7, scale = 2, nullable = false)
    private BigDecimal totalPago;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;
}
