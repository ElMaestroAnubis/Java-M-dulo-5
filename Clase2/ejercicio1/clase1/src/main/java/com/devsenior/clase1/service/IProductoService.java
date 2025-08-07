package com.devsenior.clase1.service;

import java.util.List;

import com.devsenior.clase1.model.Producto;

public interface IProductoService {
    // Aquí especificamos las acciones que puede realizar el servicio de productos

    List<Producto> listarProductos();
    Producto obtenerProductoPorId(Long id);
    Producto agregarProducto(String nombre, Double precio);
    
}
