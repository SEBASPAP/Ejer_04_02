/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Actor;
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
public class ActorServicio implements IActorServicio {

    private static List<Actor> actorList = new ArrayList<>();

    @Override
    public Actor crear(Actor actor) {
        
        var actorBuscando = this.buscar(actor.getCodigo());
        if(actorBuscando==null){
            this.actorList.add(actor);
        }else{
            throw new RuntimeException("El Codigo inngresado ya se encu entra "+
                                       "asignado al actor : "+actorBuscando.getNombre());
        }
        try {
            this.almacenarEnArchivo(actor, "C:/Ejer0402/archivoActor.dat");
        } catch (Exception ex) {
            throw new RuntimeException("No se puede almacenar en archivo" + ex.getMessage());
        }
        return actor;
    }

    @Override
    public List<Actor> listar() {
        return this.actorList;
    }

    @Override
    public Actor modificarAct(Actor actors) {
        for (int i = 0; i < actorList.size(); i++) {
            Actor ac = actorList.get(i);
            if (ac.getCodigo() == actors.getCodigo()) {
                actorList.set(i, actors);
                break;
            }
        }
        return null;
    }

    @Override
    public Actor buscar(int codigo) {
        Actor actor=null;
        for (Actor act : this.listar()) {
            if (codigo == act.getCodigo()) {
                actor =act;
                break;
            }
        }
        return actor;
    }

    @Override
    public boolean almacenarEnArchivo(Actor actor, String rutaArchivo) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        var retorno = false;
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo, true));
            salida.writeInt(actor.getCodigo());
            salida.writeUTF(actor.getNombre());
            salida.writeUTF(actor.getNacionalidad());
            salida.writeInt(actor.getFechanacimiento());
            salida.writeInt(actor.getEdad());
            retorno = true;
        } catch (IOException e) {
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Actor> recuperarDeArchivo(String rutaArchivo) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        var actorList = new ArrayList<Actor>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while (true) {
                var codigo = entrada.readInt();
                var nombre = entrada.readUTF();
                var nacionalidad = entrada.readUTF();
                var fechaNacimiento = entrada.readInt();
                var edad = entrada.readInt();
                var actor = new Actor(codigo, nombre, nacionalidad, fechaNacimiento, edad);
                actorList.add(actor);
            }
        } catch (IOException e) {
            entrada.close();
        }
        return ActorServicio.actorList;
    }
}
