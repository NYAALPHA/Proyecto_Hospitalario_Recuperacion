package com.elsilencio.Trabajador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface trabajadorRepository extends JpaRepository<trabajadorEntity, Integer> {
    
    // Buscar trabajador por su nombre de usuario (Login)
    Optional<trabajadorEntity> findByLogin(String login);
}