package com.elsilencio.Habitacion;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class habitacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhabitacion;

    @Column(length = 4, nullable = false)
    private String numero;

    @Column(length = 2, nullable = false)
    private String piso;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 512)
    private String caracteristicas;

    @Column(name = "precio_diario", precision = 7, scale = 2, nullable = false)
    private BigDecimal precioDiario;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private habitacionEstadoEnum estado = habitacionEstadoEnum.DISPONIBLE;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_habitacion", length = 20, nullable = false)
    private habitacionTipoEnum tipoHabitacion;
}
