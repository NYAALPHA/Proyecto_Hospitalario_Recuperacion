package com.elsilencio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class clienteService {

    @Autowired
    private clienteRepository repository;

    public List<clienteDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public clienteDTO guardarCliente(clienteDTO dto) {
        clienteEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public clienteDTO obtenerId(int id) {
        clienteEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return mapToDTO(entity);
    }

    public clienteDTO actualizar(int id, clienteDTO dto) {
        clienteEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizar campos según DTO
        entity.setCodigoCliente(dto.getCodigoCliente());

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

// MÉTODOS DE CONVERSIÓN
private clienteDTO mapToDTO(clienteEntity entity) {
    return clienteDTO.builder()
            .idpersona(entity.getIdpersona())
            .nombre(entity.getNombre())
            .apaterno(entity.getApaterno())
            .amaterno(entity.getAmaterno())
            .tipoDocumento(entity.getTipoDocumento())
            .numDocumento(entity.getNumDocumento())
            .genero(entity.getGenero())
            .direccion(entity.getDireccion())
            .telefono(entity.getTelefono())
            .email(entity.getEmail())
            .codigoCliente(entity.getCodigoCliente())
            .build();
}

private clienteEntity mapToEntity(clienteDTO dto) {
    return clienteEntity.builder()
            .idpersona(dto.getIdpersona())
            .nombre(dto.getNombre())
            .apaterno(dto.getApaterno())
            .amaterno(dto.getAmaterno())
            .tipoDocumento(dto.getTipoDocumento())
            .numDocumento(dto.getNumDocumento())
            .genero(dto.getGenero())
            .direccion(dto.getDireccion())
            .telefono(dto.getTelefono())
            .email(dto.getEmail())
            .codigoCliente(dto.getCodigoCliente())
            .build();
}
}
