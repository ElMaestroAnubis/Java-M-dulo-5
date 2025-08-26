package com.dev.aerolinea.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.aerolinea.model.Vuelo;

public class VueloRepository {

    private final Map<Long, Vuelo> vuelos = new HashMap<>();

    public List<Vuelo> findAll() {
        return new ArrayList<>(vuelos.values());
    }

  
    public Vuelo findById(Long id) {
         //TODO: Elaborar una logica mas compleja para encontrar un vuelo por id pensando en las excepciones
         return vuelos.get(id);
    }

    public void save(Vuelo vuelo) {
        vuelos.put(vuelo.getId(), vuelo);
    }

    public void deleteById(Long id) {
        vuelos.remove(id);
    }


}
