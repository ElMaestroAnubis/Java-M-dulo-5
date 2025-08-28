package com.dev.aerolinea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.aerolinea.exception.PasajeroNotFoundException;
import com.dev.aerolinea.exception.VueloNoDisponibleException;
import com.dev.aerolinea.exception.reservaNotFoundException;
import com.dev.aerolinea.model.Pasajero;
import com.dev.aerolinea.model.Reserva;
import com.dev.aerolinea.model.Vuelo;
import com.dev.aerolinea.repository.PasajeroRepository;
import com.dev.aerolinea.repository.ReservaRepository;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloService vueloService;

    public ReservaService(ReservaRepository reservaRepository, PasajeroRepository pasajeroRepository,VueloService vueloService){
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloService = vueloService;
    }

    //consultar todas las reservas
    public List<Reserva> getReservas(){
        return reservaRepository.findAll();
    }

    public Reserva crearReserva(Long vueloId, Long pasajeroId) throws VueloNoDisponibleException,
                                  PasajeroNotFoundException{
        //1. Obtener el vuelo con ese id
        Vuelo vuelo = vueloService.getVueloById(vueloId);
        vueloService.reducirAsientosDisponibles(vueloId);
        
        //2. Validamos el pasajero
        Pasajero pasajero = pasajeroRepository.findPasajeroById(pasajeroId);
        
        // 3. Obtenemos los asientos disponibles
        int asientoAsignado = vuelo.getAsientosDisponibles() + 1;

        //4. Creamos con lo obtenido en 1,2,3 la reserva
        Reserva reserva = new Reserva(pasajero, vuelo, asientoAsignado);
        vueloService.reducirAsientosDisponibles(vueloId);
        return reservaRepository.save(reserva);                            
    
    }

    public void cancelarReserva(Long idReserva){
        Reserva reserva = reservaRepository.delete(idReserva);
        if(reserva == null) throw new reservaNotFoundException("Reserva no encontrada");

        //si se cancela o elimina la reserva, al vuelo correspondiente hay que aumentarle los asientos dispo.
        vueloService.aumentarAsientosDisponibles(reserva.getVuelo().getId());
        
    }

    //TODO: getReservaById(Long idReserva);
}
