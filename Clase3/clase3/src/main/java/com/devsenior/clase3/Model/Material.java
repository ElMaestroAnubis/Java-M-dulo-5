package com.devsenior.clase3.Model;

public class Material {
    private long id;
    private String nombre;
    private String unidadMetrica;
    private int cantidadDisponible;
    private String ubicacion;

    public Material() {
    }

    public Material(long id, String nombre, String unidadMetrica, int cantidadDisponible, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMetrica = unidadMetrica;
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacion = ubicacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMetrica() {
        return unidadMetrica;
    }

    public void setUnidadMetrica(String unidadMetrica) {
        this.unidadMetrica = unidadMetrica;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
}
