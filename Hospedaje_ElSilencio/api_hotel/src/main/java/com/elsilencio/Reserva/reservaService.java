package com.elsilencio.Reserva;

import com.elsilencio.Cliente.clienteEntity;
import com.elsilencio.Habitacion.habitacionEntity;
import com.elsilencio.Trabajador.trabajadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class reservaService {

    @Autowired
    private reservaRepository repository;

    public List<reservaDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public reservaDTO guardarReserva(reservaDTO dto) {
        reservaEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public reservaDTO obtenerId(int id) {
        reservaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return mapToDTO(entity);
    }

    public reservaDTO actualizar(int id, reservaDTO dto) {
        reservaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // Actualizar campos
        entity.setTipoReserva(dto.getTipoReserva());
        entity.setFechaReserva(dto.getFechaReserva());
        entity.setFechaIngresa(dto.getFechaIngresa());
        entity.setFechaSalida(dto.getFechaSalida());
        entity.setCostoAlojamiento(dto.getCostoAlojamiento());
        entity.setEstado(dto.getEstado());

        // Relaciones: habitacion, cliente, trabajador
        if (dto.getIdhabitacion() != null) {
            habitacionEntity habitacion = new habitacionEntity();
            habitacion.setIdhabitacion(dto.getIdhabitacion());
            entity.setHabitacion(habitacion);
        }
        if (dto.getIdcliente() != null) {
            clienteEntity cliente = new clienteEntity();
            cliente.setIdpersona(dto.getIdcliente());
            entity.setCliente(cliente);
        }
        if (dto.getIdtrabajador() != null) {
            trabajadorEntity trabajador = new trabajadorEntity();
            trabajador.setIdpersona(dto.getIdtrabajador()); // clave compartida con persona
            entity.setTrabajador(trabajador);
        }

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN
    private reservaDTO mapToDTO(reservaEntity entity) {
        return reservaDTO.builder()
                .idreserva(entity.getIdreserva())
                .idhabitacion(entity.getHabitacion().getIdhabitacion())
                .idcliente(entity.getCliente().getIdpersona())
                .idtrabajador(entity.getTrabajador().getIdpersona()) // usamos idpersona como PK
                .tipoReserva(entity.getTipoReserva())
                .fechaReserva(entity.getFechaReserva())
                .fechaIngresa(entity.getFechaIngresa())
                .fechaSalida(entity.getFechaSalida())
                .costoAlojamiento(entity.getCostoAlojamiento())
                .estado(entity.getEstado())
                .build();
    }

    private reservaEntity mapToEntity(reservaDTO dto) {
        return reservaEntity.builder()
                .idreserva(dto.getIdreserva())
                .tipoReserva(dto.getTipoReserva())
                .fechaReserva(dto.getFechaReserva())
                .fechaIngresa(dto.getFechaIngresa())
                .fechaSalida(dto.getFechaSalida())
                .costoAlojamiento(dto.getCostoAlojamiento())
                .estado(dto.getEstado())
                // Relaciones solo por ID
                .habitacion(habitacionEntity.builder().idhabitacion(dto.getIdhabitacion()).build())
                .cliente(clienteEntity.builder().idpersona(dto.getIdcliente()).build())
                .trabajador(trabajadorEntity.builder().idpersona(dto.getIdtrabajador()).build())
                .build();
    }
}