package com.elsilencio.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface reservaRepository extends JpaRepository<reservaEntity, Integer> {
    
    // Buscar todas las reservas de un cliente específico
    List<reservaEntity> findByCliente_Idpersona(Integer idcliente);
    
    // Buscar reservas activas por habitación
    List<reservaEntity> findByHabitacion_Idhabitacion(Integer idhabitacion);
}