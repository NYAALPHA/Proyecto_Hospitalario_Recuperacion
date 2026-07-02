package com.elsilencio.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personaRepository extends JpaRepository<personaEntity, Integer> {
    // Extiende de JpaRepository<Entidad, Tipo de la Llave Primaria>
}
