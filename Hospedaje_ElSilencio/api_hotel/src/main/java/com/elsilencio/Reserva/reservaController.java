package com.elsilencio.Reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class reservaController {

    @Autowired
    private reservaService service;

    // GET: listar todas las reservas
    @GetMapping
    public List<reservaDTO> listarReservas() {
        return service.obtenerTodos();
    }

    // GET: obtener reserva por ID
    @GetMapping("/{id}")
    public reservaDTO obtenerReserva(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nueva reserva
    @PostMapping
    public reservaDTO crearReserva(@RequestBody @Valid reservaDTO dto) {
        return service.guardarReserva(dto);
    }

    // PUT: actualizar reserva existente
    @PutMapping("/{id}")
    public reservaDTO actualizarReserva(@PathVariable int id, @RequestBody @Valid reservaDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar reserva por ID
    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        service.eliminar(id);
    }
}