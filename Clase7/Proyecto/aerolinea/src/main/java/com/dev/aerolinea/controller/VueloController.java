package com.dev.aerolinea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.aerolinea.exception.VueloNotFoundException;
import com.dev.aerolinea.model.Vuelo;
import com.dev.aerolinea.service.VueloService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
   
    private final VueloService vueloService;

    public VueloController(VueloService vueloService){
        this.vueloService = vueloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVuelo(@PathVariable Long id) {
       try {
         Vuelo vuelo = vueloService.getVueloById(id);
         return ResponseEntity.ok(vuelo); //configura la respuesta http de nuestro controlador
       } catch (VueloNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @PostMapping
    public ResponseEntity<Vuelo> crearVueloString(@RequestBody Vuelo vuelo) {
      Vuelo vueloNuevo = vueloService.crearVuelo(vuelo);
      return ResponseEntity.status(HttpStatus.CREATED).body(vueloNuevo);
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> listarVuelos(){
        return ResponseEntity.ok(vueloService.getVuelos());
    }
    
    //TODO: Implementar eliminar vuelo
}
