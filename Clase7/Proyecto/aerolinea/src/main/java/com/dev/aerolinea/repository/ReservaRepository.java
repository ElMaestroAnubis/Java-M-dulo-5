package com.dev.aerolinea.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dev.aerolinea.model.Reserva;

@Repository
public class ReservaRepository {
    private final Map<Long, Reserva> reservas = new HashMap<>();
    private long idCounter = 1;

    public List<Reserva> findAll() {
        return new ArrayList<>(reservas.values());
    }

    public Reserva findById(Long id) {
        return reservas.get(id);
    }

    public Reserva save(Reserva reserva) {
        Reserva Nuevareserva = new Reserva(idCounter++, reserva.getPasajero(), reserva.getVuelo(), reserva.getAsiento());
        reservas.put(Nuevareserva.getId(), Nuevareserva);
        return Nuevareserva;
    }
    
    public Reserva delete(Long id) {
       return reservas.remove(id);
    }
}
