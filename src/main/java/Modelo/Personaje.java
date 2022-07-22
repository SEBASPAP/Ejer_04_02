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
public class Personaje implements Serializable{
    public int codigo;
    public String nombrePer;
    public String funcionPer;
    public String generoMof;
    Actor Actor;
    Pelicula Pelicula;

    public Personaje(int codigo, String nombrePer, String funcionPer, String generoMof) {
        this.codigo = codigo;
        this.nombrePer = nombrePer;
        this.funcionPer = funcionPer;
        this.generoMof = generoMof;
    }

    public Personaje(int codigo, String nombrePer, String funcionPer, String generoMof, Actor Actor, Pelicula Pelicula) {
        this.codigo = codigo;
        this.nombrePer = nombrePer;
        this.funcionPer = funcionPer;
        this.generoMof = generoMof;
        this.Actor = Actor;
        this.Pelicula = Pelicula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public String getFuncionPer() {
        return funcionPer;
    }

    public void setFuncionPer(String funcionPer) {
        this.funcionPer = funcionPer;
    }

    public String getGeneroMof() {
        return generoMof;
    }

    public void setGeneroMof(String generoMof) {
        this.generoMof = generoMof;
    }

    public Actor getActor() {
        return Actor;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

    public Pelicula getPelicula() {
        return Pelicula;
    }

    public void setPelicula(Pelicula Pelicula) {
        this.Pelicula = Pelicula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
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
        final Personaje other = (Personaje) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Personaje{" + "codigo=" + codigo + ", nombrePer=" 
                + nombrePer + ", funcionPer=" + funcionPer + ", generoMof=" 
                + generoMof + ", Actor=" + Actor + ", Pelicula=" + Pelicula + '}';
    }
    
}
