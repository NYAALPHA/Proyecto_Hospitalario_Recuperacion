package com.elsilencio.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class productoService {

    @Autowired
    private productoRepository repository;

    public List<productoDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public productoDTO guardarProducto(productoDTO dto) {
        productoEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public productoDTO obtenerId(int id) {
        productoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return mapToDTO(entity);
    }

    public productoDTO actualizar(int id, productoDTO dto) {
        productoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar campos
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setUnidadMedida(dto.getUnidadMedida());
        entity.setPrecioVenta(dto.getPrecioVenta());

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN
    private productoDTO mapToDTO(productoEntity entity) {
        return productoDTO.builder()
                .idproducto(entity.getIdproducto())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .unidadMedida(entity.getUnidadMedida())
                .precioVenta(entity.getPrecioVenta())
                .build();
    }

    private productoEntity mapToEntity(productoDTO dto) {
        return productoEntity.builder()
                .idproducto(dto.getIdproducto())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .unidadMedida(dto.getUnidadMedida())
                .precioVenta(dto.getPrecioVenta())
                .build();
    }
}