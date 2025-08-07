package com.devsenior.clase1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.clase1.model.Producto;
import com.devsenior.clase1.service.IProductoService;
import com.devsenior.clase1.service.ProductoServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/productos") //esto indica que este controlador maneja las rutas que comienzan con /productos
public class ProductoController {

    private final IProductoService productoService;

   
    
    public ProductoController() {
        this.productoService = new ProductoServiceImpl(); // Inicialización del servicio
    }

    @GetMapping()
    public List<Producto> obtenerProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }



}
