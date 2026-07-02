package com.elsilencio.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elsilencio.Cliente.clienteEntity;
import com.elsilencio.Habitacion.habitacionEntity;
import com.elsilencio.Trabajador.trabajadorEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class reservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhabitacion", nullable = false)
    private habitacionEntity habitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", nullable = false)
    private clienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtrabajador", nullable = false)
    private trabajadorEntity trabajador;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_reserva", length = 20, nullable = false)
    private reservaTipoEnum tipoReserva;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "fecha_ingresa", nullable = false)
    private LocalDate fechaIngresa;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "costo_alojamiento", precision = 7, scale = 2, nullable = false)
    private BigDecimal costoAlojamiento;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private reservaTipoEnum estado;
}
