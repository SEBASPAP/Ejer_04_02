/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Pelicula;
import java.util.List;

/**
 *
 * @author paulp
 */
public interface IPeliculaServicio {
    public Pelicula crear(Pelicula pelicula);
    public List<Pelicula>listar();
    public Pelicula buscar(int codigo);
    public boolean almacenarEnArchivo(Pelicula pelicula, String rutaArchivo) throws Exception;
    public List<Pelicula> recuperarDeArchivo(String rutaArchivo) throws Exception;
}
