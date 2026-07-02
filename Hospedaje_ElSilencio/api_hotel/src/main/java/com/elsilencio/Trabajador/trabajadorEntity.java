package com.elsilencio.Trabajador;

import java.math.BigDecimal;

import com.elsilencio.Persona.personaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "trabajador")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class trabajadorEntity extends personaEntity {
    @Id
    @Column(name = "idpersona")
    private Integer idpersona;

    @Column(name = "sueldo", nullable = false, precision = 7, scale = 2)
    private BigDecimal sueldo;

    @Column(name = "acceso", nullable = false, length = 15)
    private String acceso;

    @Column(name = "login", nullable = false, length = 15, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private trabajadorEstadoEnum estado = trabajadorEstadoEnum.ACTIVO;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private personaEntity persona;
}
