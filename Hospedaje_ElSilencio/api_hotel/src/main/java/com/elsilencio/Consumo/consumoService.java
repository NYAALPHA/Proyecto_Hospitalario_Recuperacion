package com.elsilencio.Consumo;

import com.elsilencio.Producto.productoEntity;
import com.elsilencio.Reserva.reservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class consumoService {

    @Autowired
    private consumoRepository repository;

    public List<consumoDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public consumoDTO guardarConsumo(consumoDTO dto) {
        consumoEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public consumoDTO obtenerId(int id) {
        consumoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));
        return mapToDTO(entity);
    }

    public consumoDTO actualizar(int id, consumoDTO dto) {
        consumoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));

        // Actualizar campos
        entity.setCantidad(dto.getCantidad());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setEstado(dto.getEstado());

        // Relaciones: si quieres actualizar reserva o producto
        if (dto.getIdreserva() != null) {
            reservaEntity reserva = new reservaEntity();
            reserva.setIdreserva(dto.getIdreserva());
            entity.setReserva(reserva);
        }
        if (dto.getIdproducto() != null) {
            productoEntity producto = new productoEntity();
            producto.setIdproducto(dto.getIdproducto());
            entity.setProducto(producto);
        }

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN
    private consumoDTO mapToDTO(consumoEntity entity) {
        return consumoDTO.builder()
                .idconsumo(entity.getIdconsumo())
                .idreserva(entity.getReserva().getIdreserva())
                .idproducto(entity.getProducto().getIdproducto())
                .cantidad(entity.getCantidad())
                .precioVenta(entity.getPrecioVenta())
                .estado(entity.getEstado())
                .build();
    }

    private consumoEntity mapToEntity(consumoDTO dto) {
        return consumoEntity.builder()
                .idconsumo(dto.getIdconsumo())
                .cantidad(dto.getCantidad())
                .precioVenta(dto.getPrecioVenta())
                .estado(dto.getEstado())
                // Relaciones: solo asignamos por ID
                .reserva(reservaEntity.builder().idreserva(dto.getIdreserva()).build())
                .producto(productoEntity.builder().idproducto(dto.getIdproducto()).build())
                .build();
    }
}
