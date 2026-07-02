package com.elsilencio.Cliente;

import com.elsilencio.Persona.personaEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class clienteEntity extends personaEntity {

    @Id
    @Column(name = "idpersona")
    private Integer idpersona;

    @Column(name = "codigo_cliente", nullable = false, length = 10, unique = true)
    private String codigoCliente;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    private personaEntity persona;
}