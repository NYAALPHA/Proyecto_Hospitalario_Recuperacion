package com.elsilencio.Habitacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class habitacionService {

    @Autowired
    private habitacionRepository repository;

    public List<habitacionDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public habitacionDTO guardarHabitacion(habitacionDTO dto) {
        habitacionEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public habitacionDTO obtenerId(int id){
        habitacionEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));
        return mapToDTO(entity);
    }

    public habitacionDTO actualizar(int id, habitacionDTO dto){
        habitacionEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));
        entity.setNumero(dto.getNumero());
        entity.setPiso(dto.getPiso());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCaracteristicas(dto.getCaracteristicas());
        entity.setPrecioDiario(dto.getPrecioDiario());
        entity.setEstado(dto.getEstado());
        entity.setTipoHabitacion(dto.getTipoHabitacion());

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN (Mapeo)
    //GET POST PUT CUANDO DEVUELVES DATOS A LA HABITACION
    private habitacionDTO mapToDTO(habitacionEntity entity) {
        return habitacionDTO.builder().idhabitacion(entity.getIdhabitacion()).numero(entity.getNumero())
                .piso(entity.getPiso()).descripcion(entity.getDescripcion())
                .caracteristicas(entity.getCaracteristicas()).precioDiario(entity.getPrecioDiario())
                .estado(entity.getEstado()).tipoHabitacion(entity.getTipoHabitacion()).build();
    }

    //POST PUT CUANDO RECIBES DATOS DE LA HABITACION
    private habitacionEntity mapToEntity(habitacionDTO dto) {
        return habitacionEntity.builder().idhabitacion(dto.getIdhabitacion()).numero(dto.getNumero())
                .piso(dto.getPiso()).descripcion(dto.getDescripcion()).caracteristicas(dto.getCaracteristicas())
                .precioDiario(dto.getPrecioDiario()).estado(dto.getEstado()).tipoHabitacion(dto.getTipoHabitacion())
                .build();
    }
}