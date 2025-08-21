package com.dev.senior.Service;

import java.util.List;

import com.dev.senior.Model.Pelicula;
import com.dev.senior.Repository.PeliculaRepository;

// Principio D: Dependency Inversion Principle
// la clase depende de la abstracción (interfaz) y no de la implementación concreta.
public class PeliculaServiceImpl implements PeliculaService {
   
    
    private final PeliculaRepository repository;

    public PeliculaServiceImpl(PeliculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pelicula> getAllPeliculas() {
       return repository.getPeliculas();
    }

    @Override
    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null && pelicula.getId() != null) {
            repository.addPelicula(pelicula);
        } else {
            throw new IllegalArgumentException("Pelicula or ID cannot be null");
        }
    }
}
