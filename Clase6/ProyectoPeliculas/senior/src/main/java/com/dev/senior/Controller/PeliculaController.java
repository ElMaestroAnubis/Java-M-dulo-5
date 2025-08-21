package com.dev.senior.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dev.senior.Model.Pelicula;
import com.dev.senior.Service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private  final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @PostMapping
    public void agregarPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.addPelicula(pelicula);
    }


}
