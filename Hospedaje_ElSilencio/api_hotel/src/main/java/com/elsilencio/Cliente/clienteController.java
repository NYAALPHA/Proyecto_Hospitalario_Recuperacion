package com.elsilencio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class clienteController {

    @Autowired
    private clienteService service;

    // GET: listar todos los clientes
    @GetMapping
    public List<clienteDTO> listarClientes() {
        return service.obtenerTodos();
    }

    // GET: obtener cliente por ID
    @GetMapping("/{id}")
    public clienteDTO obtenerCliente(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nuevo cliente
    @PostMapping
    public clienteDTO crearCliente(@RequestBody @Valid clienteDTO dto) {
        return service.guardarCliente(dto);
    }

    // PUT: actualizar cliente existente
    @PutMapping("/{id}")
    public clienteDTO actualizarCliente(@PathVariable int id, @RequestBody @Valid clienteDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar cliente por ID
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id) {
        service.eliminar(id);
    }
}
