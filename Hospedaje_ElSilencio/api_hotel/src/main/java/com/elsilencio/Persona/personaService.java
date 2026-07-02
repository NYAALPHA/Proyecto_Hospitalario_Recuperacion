package com.elsilencio.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class personaService {

    @Autowired
    private personaRepository repository;

    public List<personaDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public personaDTO guardarPersona(personaDTO dto) {
        personaEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public personaDTO obtenerId(int id) {
        personaEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return mapToDTO(entity);
    }

    public personaDTO actualizar(int id, personaDTO dto) {
        personaEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        // Actualizar campos
        entity.setNombre(dto.getNombre());
        entity.setApaterno(dto.getApaterno());
        entity.setAmaterno(dto.getAmaterno());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setNumDocumento(dto.getNumDocumento());
        entity.setGenero(dto.getGenero());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getEmail());

        return mapToDTO(repository.save(entity));
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    // MÉTODOS DE CONVERSIÓN (Mapeo)
    //GET POST PUT CUANDO DEVUELVES DATOS AL CLIENTE
    private personaDTO mapToDTO(personaEntity entity) {
        return personaDTO.builder().idpersona(entity.getIdpersona()).nombre(entity.getNombre())
                .apaterno(entity.getApaterno()).amaterno(entity.getAmaterno()).tipoDocumento(entity.getTipoDocumento())
                .numDocumento(entity.getNumDocumento()).genero(entity.getGenero()).direccion(entity.getDireccion())
                .telefono(entity.getTelefono()).email(entity.getEmail()).build();
    }

    //POST PUT CUANDO RECIBES DATOS DEL CLIENTE
    private personaEntity mapToEntity(personaDTO dto) {
        return personaEntity.builder().idpersona(dto.getIdpersona()).nombre(dto.getNombre()).apaterno(dto.getApaterno())
                .amaterno(dto.getAmaterno()).tipoDocumento(dto.getTipoDocumento()).numDocumento(dto.getNumDocumento())
                .genero(dto.getGenero()).direccion(dto.getDireccion()).telefono(dto.getTelefono()).email(dto.getEmail())
                .build();
    }
}
