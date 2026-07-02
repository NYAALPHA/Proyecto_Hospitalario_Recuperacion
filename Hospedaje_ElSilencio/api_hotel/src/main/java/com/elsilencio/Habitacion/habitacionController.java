package com.elsilencio.Habitacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
public class habitacionController {

    @Autowired
    private habitacionService service;

    // GET: listar todas las habitaciones
    @GetMapping
    public List<habitacionDTO> listarHabitaciones() {
        return service.obtenerTodos();
    }

    // GET: obtener habitacion por ID
    @GetMapping("/{id}")
    public habitacionDTO obtenerHabitacion(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nueva persona
    @PostMapping
    public habitacionDTO crearHabitacion(@RequestBody @Valid habitacionDTO dto) {
        return service.guardarHabitacion(dto);
    }

    // PUT: actualizar habitacion existente
    @PutMapping("/{id}")
    public habitacionDTO actualizarHabitacion(@PathVariable int id, @RequestBody @Valid habitacionDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar persona por ID
    @DeleteMapping("/{id}")
    public void eliminarHabitacion(@PathVariable int id) {
        service.eliminar(id);
    }
}