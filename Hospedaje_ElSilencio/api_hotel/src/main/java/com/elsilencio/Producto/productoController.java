package com.elsilencio.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class productoController {

    @Autowired
    private productoService service;

    // GET: listar todos los productos
    @GetMapping
    public List<productoDTO> listarProductos() {
        return service.obtenerTodos();
    }

    // GET: obtener producto por ID
    @GetMapping("/{id}")
    public productoDTO obtenerProducto(@PathVariable int id) {
        return service.obtenerId(id);
    }

    // POST: crear nuevo producto
    @PostMapping
    public productoDTO crearProducto(@RequestBody @Valid productoDTO dto) {
        return service.guardarProducto(dto);
    }

    // PUT: actualizar producto existente
    @PutMapping("/{id}")
    public productoDTO actualizarProducto(@PathVariable int id, @RequestBody @Valid productoDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE: eliminar producto por ID
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        service.eliminar(id);
    }
}