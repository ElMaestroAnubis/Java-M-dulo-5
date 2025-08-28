package com.dev.aerolinea.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dev.aerolinea.model.Vuelo;

@Repository
public class VueloRepository {

    private final Map<Long, Vuelo> vuelos = new HashMap<>();

    public List<Vuelo> findAll() {
        return new ArrayList<>(vuelos.values());
    }

  
    public Vuelo findById(Long id) {
         return vuelos.get(id);
    }

    public Vuelo save(Vuelo vuelo) {
        return vuelos.put(vuelo.getId(), vuelo);
    }

    public void deleteById(Long id) {
        vuelos.remove(id);
    }


}
