package com.elsilencio.Trabajador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class trabajadorService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private trabajadorRepository repository;

    public List<trabajadorDTO> obtenerTodos() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public trabajadorDTO guardarTrabajador(trabajadorDTO dto) {
        String passwordEncriptada = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(passwordEncriptada);
        trabajadorEntity entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public trabajadorDTO obtenerId(int id) {
        trabajadorEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
        return mapToDTO(entity);
    }

    public trabajadorDTO actualizar(int id, trabajadorDTO dto) {
        trabajadorEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));

        // Actualizar campos propios de trabajador
        entity.setSueldo(dto.getSueldo());
        entity.setAcceso(dto.getAcceso());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setEstado(dto.getEstado());

        // También puedes actualizar atributos heredados de persona si lo deseas
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

    // MÉTODOS DE CONVERSIÓN
    private trabajadorDTO mapToDTO(trabajadorEntity entity) {
        return trabajadorDTO.builder()
                .idpersona(entity.getIdpersona())
                .nombre(entity.getNombre())
                .apaterno(entity.getApaterno())
                .amaterno(entity.getAmaterno())
                .sueldo(entity.getSueldo())
                .acceso(entity.getAcceso())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .estado(entity.getEstado())
                .build();
    }

    private trabajadorEntity mapToEntity(trabajadorDTO dto) {
        return trabajadorEntity.builder()
                .idpersona(dto.getIdpersona())
                .nombre(dto.getNombre())
                .apaterno(dto.getApaterno())
                .amaterno(dto.getAmaterno())
                .sueldo(dto.getSueldo())
                .acceso(dto.getAcceso())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .estado(dto.getEstado())
                .build();
    }
}