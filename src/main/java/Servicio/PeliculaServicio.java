/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Pelicula;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulp
 */
public class PeliculaServicio implements IPeliculaServicio {

    private static List<Pelicula> peliculaList = new ArrayList<>();

    @Override
    public Pelicula crear(Pelicula pelicula) {
        var peliculaBuscando = this.buscar(pelicula.getCodigo());
        if (peliculaBuscando == null) {
            this.peliculaList.add(pelicula);
        } else {
            throw new RuntimeException("El Codigo inngresado ya se encuentra "
                    + "asignado a la Pelicula: " + peliculaBuscando.getNombre());
        }
        try {
            this.almacenarEnArchivo(pelicula, "C:/Ejer0402/archivoPelicula.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede almacenar en archivo" + ex.getMessage());
        }
        return pelicula;
    }

    @Override
    public List<Pelicula> listar() {
        return this.peliculaList;
    }

    @Override
    public Pelicula buscar(int codigo) {
        Pelicula pelicula = null;
        for (Pelicula pel : this.listar()) {
            if (codigo == pel.getCodigo()) {
                pelicula = pel;
                break;
            }
        }
        return pelicula;
    }

    @Override
    public boolean almacenarEnArchivo(Pelicula pelicula, String rutaArchivo) throws Exception {
        var retorno = false;
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo, true));
            salida.writeInt(pelicula.getCodigo());
            salida.writeUTF(pelicula.getNombre());
            salida.writeUTF(pelicula.getGenero());
            salida.writeUTF(pelicula.getPaisOrigen());
            salida.writeInt(pelicula.getFechaPublicacion());
            retorno = true;
        } catch (IOException e) {
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Pelicula> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var peliculaList = new ArrayList<Pelicula>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while (true) {
                var codigo = entrada.readInt();
                var nombre = entrada.readUTF();
                var genero = entrada.readUTF();
                var paisOrigen = entrada.readUTF();
                var fechaPublicacion = entrada.readInt();
                var pelicula = new Pelicula(codigo, nombre, genero, paisOrigen, fechaPublicacion);
                peliculaList.add(pelicula);
            }
        } catch (IOException e) {
            entrada.close();
        }
        return PeliculaServicio.peliculaList;
    }

}
