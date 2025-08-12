package com.devsenior.clase3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenior.clase3.Model.Material;
import com.devsenior.clase3.Repositorio.MaterialRepository;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private MaterialRepository repository;

    public Material guardarMaterial(Material material){
        if(material.getCantidadDisponible() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }   

        material.setNombre(material.getNombre().trim().toUpperCase());
        material.setUnidadMetrica(material.getUnidadMetrica().trim().toUpperCase());
        return repository.guardarMaterial(material);

    }

    public Material buscarMaterialPorId(Long id){
        return repository.getMaterialById(id);          
    }

    public void eliminarMaterial(Long id){
        Material material = repository.getMaterialById(id);
        if (material == null) {
            throw new IllegalArgumentException("Material no encontrado");
        }
        repository.deleteMaterial(id);
    }

   public  List<Material> listarMateriales(){
        return repository.getAllMaterials();
    }

    public Material actualizarCantidad(Long id, int cantidad) {
        Material material = repository.getMaterialById(id);
        if (material == null) {
            throw new IllegalArgumentException("Material no encontrado");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        material.setCantidadDisponible(cantidad);
        return repository.guardarMaterial(material);
   }



}
