package com.dev.aerolinea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dev.aerolinea.exception.PasajeroNotFoundException;
import com.dev.aerolinea.model.Pasajero;

public class PasajeroRepository {
    private final Map<Long, Pasajero> pasajeros = new HashMap<>();

    public Pasajero findPasajeroById(Long id){
        return Optional.ofNullable(pasajeros.get(id))
                .orElseThrow(()-> new PasajeroNotFoundException("Pasajero no encontrado"));
    }

    public List<Pasajero> findAllPasajeros(){
        return List.copyOf(pasajeros.values());
    }

    public void savePasajero(Pasajero pasajero){
        pasajeros.put(pasajero.getId(), pasajero);
    }


}
