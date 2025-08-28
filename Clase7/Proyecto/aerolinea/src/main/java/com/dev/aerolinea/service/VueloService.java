package com.dev.aerolinea.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.aerolinea.exception.VueloNoDisponibleException;
import com.dev.aerolinea.exception.VueloNotFoundException;
import com.dev.aerolinea.model.Vuelo;
import com.dev.aerolinea.repository.VueloRepository;

@Service
public class VueloService {

    
    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> getVuelos() {
        return vueloRepository.findAll();
    }
    

    public void crearVuelo(Vuelo vuelo) {
        vueloRepository.save(vuelo);
    }

    public void eliminarVuelo(Long id) {
        Vuelo vuelo = vueloRepository.findById(id);
        if(vuelo == null) throw new VueloNotFoundException("No se encontro el vuelo con id: " + id);  
        vueloRepository.deleteById(id);
    }

    public Vuelo getVueloById(Long id) {  
        Vuelo vuelo = vueloRepository.findById(id);
        if(vuelo == null) throw new VueloNotFoundException("No se encontro el vuelo con id: " + id);
        return vuelo;
    }

    public void reducirAsientosDisponibles(Long id){
        Vuelo vuelo = getVueloById(id);
        if(vuelo.getAsientosDisponibles() <= 0) {
           throw new VueloNoDisponibleException("No hay asientos para restar en el vuelo con id: " + id);
        } 
        vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - 1);
    }

    public void aumentarAsientosDisponibles(Long id){
        Vuelo vuelo = getVueloById(id);
        vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() + 1);
    }
}
