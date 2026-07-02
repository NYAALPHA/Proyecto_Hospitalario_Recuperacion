package com.elsilencio.Habitacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface habitacionRepository extends JpaRepository<habitacionEntity, Integer> {
    
    // Ejemplo de consulta personalizada: buscar por piso
    List<habitacionEntity> findByPiso(String piso);
    
    // Ejemplo: buscar solo las que están disponibles
    List<habitacionEntity> findByEstado(habitacionEstadoEnum estado);
}