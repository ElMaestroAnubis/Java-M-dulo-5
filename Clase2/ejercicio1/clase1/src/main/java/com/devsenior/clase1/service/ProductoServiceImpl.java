package com.devsenior.clase1.service;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.clase1.model.Producto;

public class ProductoServiceImpl implements IProductoService {

    //atributo
    private final List<Producto> productos;

    public ProductoServiceImpl() {
        this.productos = new ArrayList<>();
        // Inicializamos con algunos productos de ejemplo
        productos.add(new Producto(1L, "Producto 1", 10.0));
        productos.add(new Producto(2L, "Producto 2", 20.0));
        productos.add(new Producto(3L, "Producto 3", 30.0));
    }

    @Override
    public List<Producto> listarProductos() {
        return productos;
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Producto agregarProducto(String nombre, Double precio) {
        Long nuevoId = (long) (productos.size() + 1);
        Producto nuevoProducto = new Producto(nuevoId, nombre, precio);
        productos.add(nuevoProducto);
        return nuevoProducto;
    }
    




    
}
