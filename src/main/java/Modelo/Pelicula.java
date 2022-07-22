/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author paulp
 */
public class Pelicula implements Serializable{
    public int codigo;
    public String nombre;
    public String genero;
    public String paisOrigen;
    public int fechaPublicacion;

    public Pelicula(int codigo, String nombre, String genero, String paisOrigen, int fechaPublicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", paisOrigen=" + paisOrigen + ", fechaPublicacion=" + fechaPublicacion + '}';
    }
    
}
