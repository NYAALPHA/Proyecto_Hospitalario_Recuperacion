package com.elsilencio.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class pagoController {

    @Autowired
    private pagoService service;

    // GET: listar todos los pagos
    @GetMapping
    public List<pagoDTO> listarPagos() {
        return service.obtenerTodos();
    }

    // GET: obtener pago por ID
    @GetMapping("/{id}")
    public pagoDTO obtenerPago(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nuevo pago
    @PostMapping
    public pagoDTO crearPago(@RequestBody @Valid pagoDTO dto) {
        return service.guardarPago(dto);
    }

    // PUT: actualizar pago existente
    @PutMapping("/{id}")
    public pagoDTO actualizarPago(@PathVariable int id, @RequestBody @Valid pagoDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar pago por ID
    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable int id) {
        service.eliminar(id);
    }
}