package com.devsenior.clase3.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.clase3.Model.Material;
import com.devsenior.clase3.Service.IMaterialService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/materiales")
public class MaterialController {
    


    @Autowired
    private IMaterialService service;

    @PostMapping
    public Material guardarMaterial(@RequestBody Material material) {
        return service.guardarMaterial(material);
    }
    
    @GetMapping
    public List<Material> listarMateriales() {
        return service.listarMateriales();
    }

    @GetMapping("/{id}") // ruta o path: /materiales/1
    public Material buscarMaterialPorId(@PathVariable Long id) {
        return service.buscarMaterialPorId(id);
    }
   
    @PutMapping("/{id}/cantidad/{cantidad}") // ruta o path: /materiales/1/cantidad/10
    public Material actualizarCantidad(@PathVariable Long id, @PathVariable int cantidad) {
        return service.actualizarCantidad(id, cantidad);
    }

    @DeleteMapping("/{id}") // ruta o path: /materiales/1
    public void eliminarMaterial(@PathVariable Long id) {
        service.eliminarMaterial(id);
    }
}
