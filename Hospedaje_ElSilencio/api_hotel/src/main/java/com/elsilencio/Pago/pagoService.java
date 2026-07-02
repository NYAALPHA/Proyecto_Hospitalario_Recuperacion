package com.elsilencio.Pago;

import com.elsilencio.Reserva.reservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class pagoService {

    @Autowired
    private pagoRepository repository;

    public List<pagoDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public pagoDTO guardarPago(pagoDTO dto) {
        pagoEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public pagoDTO obtenerId(int id) {
        pagoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return mapToDTO(entity);
    }

    public pagoDTO actualizar(int id, pagoDTO dto) {
        pagoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        // Actualizar campos
        entity.setTipoComprobante(dto.getTipoComprobante());
        entity.setNumComprobante(dto.getNumComprobante());
        entity.setIgv(dto.getIgv());
        entity.setTotalPago(dto.getTotalPago());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setFechaPago(dto.getFechaPago());

        // Relación con reserva
        if (dto.getIdreserva() != null) {
            reservaEntity reserva = new reservaEntity();
            reserva.setIdreserva(dto.getIdreserva());
            entity.setReserva(reserva);
        }

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN
    private pagoDTO mapToDTO(pagoEntity entity) {
        return pagoDTO.builder().idpago(entity.getIdpago()).idreserva(entity.getReserva().getIdreserva())
                .tipoComprobante(entity.getTipoComprobante()).numComprobante(entity.getNumComprobante())
                .igv(entity.getIgv()).totalPago(entity.getTotalPago()).fechaEmision(entity.getFechaEmision())
                .fechaPago(entity.getFechaPago()).build();
    }

    private pagoEntity mapToEntity(pagoDTO dto) {
        return pagoEntity.builder().idpago(dto.getIdpago()).tipoComprobante(dto.getTipoComprobante())
                .numComprobante(dto.getNumComprobante()).igv(dto.getIgv()).totalPago(dto.getTotalPago())
                .fechaEmision(dto.getFechaEmision()).fechaPago(dto.getFechaPago())
                // Relación con reserva solo por ID
                .reserva(reservaEntity.builder().idreserva(dto.getIdreserva()).build()).build();
    }
}