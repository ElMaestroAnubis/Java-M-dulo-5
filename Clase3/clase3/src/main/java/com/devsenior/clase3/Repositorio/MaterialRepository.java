package com.devsenior.clase3.Repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.devsenior.clase3.Model.Material;

@Repository
public class MaterialRepository {

    private Map<Long, Material> materialMap = new HashMap<>();

    private long contadorId = 1;

    public Material guardarMaterial(Material material) {
        if (material.getId() == 0) {
            material.setId(contadorId++);
        }
        materialMap.put(material.getId(), material);
        return material;
    }


    public List<Material> getAllMaterials() {
        return new ArrayList<>(materialMap.values());
    }

    public Material getMaterialById(long id) {
        return materialMap.get(id);
    }

    public void deleteMaterial(long id) {
        materialMap.remove(id);
    }

}
