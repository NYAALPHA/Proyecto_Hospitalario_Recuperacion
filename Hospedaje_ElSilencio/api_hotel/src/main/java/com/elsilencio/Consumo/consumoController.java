package com.elsilencio.Consumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/consumo")
public class consumoController {

    @Autowired
    private consumoService service;

    // GET: listar todos los consumos
    @GetMapping
    public List<consumoDTO> listarConsumos() {
        return service.obtenerTodos();
    }

    // GET: obtener consumo por ID
    @GetMapping("/{id}")
    public consumoDTO obtenerConsumo(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nuevo consumo
    @PostMapping
    public consumoDTO crearConsumo(@RequestBody @Valid consumoDTO dto) {
        return service.guardarConsumo(dto);
    }

    // PUT: actualizar consumo existente
    @PutMapping("/{id}")
    public consumoDTO actualizarConsumo(@PathVariable int id, @RequestBody @Valid consumoDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar consumo por ID
    @DeleteMapping("/{id}")
    public void eliminarConsumo(@PathVariable int id) {
        service.eliminar(id);
    }
}