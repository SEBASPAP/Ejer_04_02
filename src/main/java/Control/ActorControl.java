/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Actor;
import Servicio.ActorServicio;
import java.util.List;

/**
 *
 * @author paulp
 */
public class ActorControl {
    
    private final ActorServicio actorServicio = new ActorServicio();
    
    public Actor crear(int codigo,String[] params, int fechaNacimiento, int edad) throws RuntimeException{  //,Personaje personaje,Pelicula pelicula
        var actor = new Actor(codigo,params[0], params[1], fechaNacimiento, edad); //,personaje,pelicula
        this.actorServicio.crear(actor);
        return actor;
    }
   
    public List<Actor> listar() {
        return this.actorServicio.listar();
    }
    
    public Actor buscar(int codigo){
        return this.actorServicio.buscar(codigo);
    }
}
