package com.devsenior.clase3.Service;

import java.util.List;

import com.devsenior.clase3.Model.Material;

public interface IMaterialService {
    Material guardarMaterial(Material material); //
    Material buscarMaterialPorId(Long id);
    void eliminarMaterial(Long id);
    Material actualizarCantidad(Long id, int cantidad);
    List<Material> listarMateriales();
}
