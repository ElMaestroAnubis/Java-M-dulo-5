package com.dev.senior.Repository;

import java.util.ArrayList;
import java.util.List;

import com.dev.senior.Model.Pelicula;

// Principio S: esta clae solo simula la existencia de un repositorio de películas
// y no tiene lógica de negocio.
public class PeliculaRepository {
    //Atributo
    private List<Pelicula> peliculas;
    
    public PeliculaRepository(){
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(1L, "Inception", "Sci-Fi"));
        peliculas.add(new Pelicula(2L, "The Godfather", "Crime"));
        peliculas.add(new Pelicula(3L, "The Dark Knight", "Action"));
        peliculas.add(new Pelicula(4L, "Pulp Fiction", "Drama"));
        peliculas.add(new Pelicula(5L, "The Shawshank Redemption", "Drama"));
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    
}
