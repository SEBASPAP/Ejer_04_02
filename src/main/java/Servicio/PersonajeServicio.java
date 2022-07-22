/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Actor;
import Modelo.Personaje;
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
public class PersonajeServicio implements IPersonajeServicio {

    private static List<Personaje> personajeList = new ArrayList<>();

    @Override
    public Personaje crear(Personaje personaje) {
            this.personajeList.add(personaje);
        try {
            this.almacenarEnArchivo(personaje, "C:/Ejer0402/archivoPersonaje.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede almacenar en archivo" + ex.getMessage());
        }
        return personaje;
    }

    @Override
    public List<Personaje> listar() {
        return this.personajeList;
    }

    @Override
    public Personaje eliminar(int codigo) {
        for (int i = 0; i < this.personajeList.size(); i++) {
            Personaje ac = this.personajeList.get(i);
            if (codigo == ac.getCodigo()) {
                this.personajeList.remove(i);
                break;
            }
        }
        return null;
    }

    @Override
    public Personaje modificarPer(Personaje personaje) {
        for (int i = 0; i < this.personajeList.size(); i++) {
            Personaje pr = this.personajeList.get(i);
            if (personaje.getCodigo() == pr.getCodigo()) {
                this.personajeList.set(i, personaje);
                break;
            }
        }
        return null;
    }
    
    @Override
    public Personaje buscar(String actor, String pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean almacenarEnArchivo(Personaje personaje, String rutaArchivo) throws Exception {
        var retorno = false;
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo, true));
            salida.writeInt(personaje.getCodigo());
            salida.writeUTF(personaje.getNombrePer());
            salida.writeUTF(personaje.getFuncionPer());
            salida.writeUTF(personaje.getGeneroMof());
            retorno = true;
        } catch (IOException e) {
            salida.close();
        }
        return retorno;}

    @Override
    public List<Personaje> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var personajeList = new ArrayList<Personaje>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while (true) {
                var codigo = entrada.readInt();
                var nombrePer = entrada.readUTF();
                var funcionPer = entrada.readUTF();
                var generoMof = entrada.readUTF();
                var personaje = new Personaje(codigo, nombrePer, funcionPer, generoMof);
                personajeList.add(personaje);
            }
        } catch (IOException e) {
            entrada.close();
        }
        return PersonajeServicio.personajeList;
    }
}
