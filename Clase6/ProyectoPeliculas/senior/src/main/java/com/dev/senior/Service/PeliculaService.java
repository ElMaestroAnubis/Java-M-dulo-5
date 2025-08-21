package com.dev.senior.Service;

import java.util.List;

import com.dev.senior.Model.Pelicula;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    void addPelicula(Pelicula pelicula);
}
