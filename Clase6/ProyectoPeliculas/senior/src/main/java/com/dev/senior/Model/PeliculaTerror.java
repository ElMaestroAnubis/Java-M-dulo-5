package com.dev.senior.Model;

public class PeliculaTerror extends Pelicula{
    private boolean tieneSangre;
    private boolean tieneSuspenso;

    public PeliculaTerror(Long id, String titulo, String genero, boolean tieneSangre, boolean tieneSuspenso) {
        super(id, titulo, genero);
        this.tieneSangre = tieneSangre;
        this.tieneSuspenso = tieneSuspenso;
    }

    public boolean isTieneSangre() {
        return tieneSangre;
    }

    public void setTieneSangre(boolean tieneSangre) {
        this.tieneSangre = tieneSangre;
    }

    public boolean isTieneSuspenso() {
        return tieneSuspenso;
    }

    public void setTieneSuspenso(boolean tieneSuspenso) {
        this.tieneSuspenso = tieneSuspenso;
    }
}
