package com.elsilencio.Trabajador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/trabajador")
public class trabajadorController {

    @Autowired
    private trabajadorService service;

    // GET: listar todos los trabajadores
    @GetMapping
    public List<trabajadorDTO> listarTrabajadores() {
        return service.obtenerTodos();
    }

    // GET: obtener trabajador por ID
    @GetMapping("/{id}")
    public trabajadorDTO obtenerTrabajador(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nuevo trabajador
    @PostMapping
    public trabajadorDTO crearTrabajador(@RequestBody @Valid trabajadorDTO dto) {
        return service.guardarTrabajador(dto);
    }

    // PUT: actualizar trabajador existente
    @PutMapping("/{id}")
    public trabajadorDTO actualizarTrabajador(@PathVariable int id, @RequestBody @Valid trabajadorDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar trabajador por ID
    @DeleteMapping("/{id}")
    public void eliminarTrabajador(@PathVariable int id) {
        service.eliminar(id);
    }
}