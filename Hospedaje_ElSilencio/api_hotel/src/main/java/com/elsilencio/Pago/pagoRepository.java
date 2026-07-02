package com.elsilencio.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagoRepository extends JpaRepository<pagoEntity, Integer> {

}