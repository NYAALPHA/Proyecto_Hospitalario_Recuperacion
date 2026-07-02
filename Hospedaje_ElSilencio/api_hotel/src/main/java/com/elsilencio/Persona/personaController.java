package com.elsilencio.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class personaController {

    @Autowired
    private personaService service;

    // GET: listar todas las personas
    @GetMapping
    public List<personaDTO> listarPersonas() {
        return service.obtenerTodos();
    }

    // GET: obtener persona por ID
    @GetMapping("/{id}")
    public personaDTO obtenerPersona(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nueva persona
    @PostMapping
    public personaDTO crearPersona(@RequestBody @Valid personaDTO dto) {
        return service.guardarPersona(dto);
    }

    // PUT: actualizar persona existente
    @PutMapping("/{id}")
    public personaDTO actualizarPersona(@PathVariable int id, @RequestBody @Valid personaDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar persona por ID
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable int id) {
        service.eliminar(id);
    }
}