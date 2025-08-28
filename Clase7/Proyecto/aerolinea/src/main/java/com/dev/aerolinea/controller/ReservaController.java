package com.dev.aerolinea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.aerolinea.model.Reserva;
import com.dev.aerolinea.service.ReservaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }
    
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva.getVuelo().getId(), reserva.getPasajero().getId());
    }
    
    @GetMapping
    public List<Reserva> getReservas() {
        return reservaService.getReservas();
    }

    /*
     *   @GetMapping("/{id}")
    public Reserva getReserva(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }
     */
  

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable Long id){
        reservaService.cancelarReserva(id);
    }
    

}
