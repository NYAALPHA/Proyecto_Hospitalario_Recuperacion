package com.elsilencio.Persona;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class personaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Integer idpersona;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apaterno", nullable = false, length = 20)
    private String apaterno;

    @Column(name = "amaterno", nullable = false, length = 20)
    private String amaterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false, length = 25)
    private personaTipoDocumentoEnum tipoDocumento;

    @Column(name = "num_documento", nullable = false, length = 15)
    private String numDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", columnDefinition = "", nullable = false, length = 10)
    private personaGeneroEnum genero;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "telefono", length = 15, unique = true)
    private String telefono;

    @Column(name = "email", length = 25, unique = true)
    private String email;
}