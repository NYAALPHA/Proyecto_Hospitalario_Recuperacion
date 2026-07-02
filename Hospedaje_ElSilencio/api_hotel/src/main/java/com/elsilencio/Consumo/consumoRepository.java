package com.elsilencio.Consumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface consumoRepository extends JpaRepository<consumoEntity, Integer> {

}
