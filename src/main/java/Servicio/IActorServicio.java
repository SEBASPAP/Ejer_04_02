/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Actor;
import java.util.List;

/**
 *
 * @author paulp
 */
public interface IActorServicio {
    public Actor crear(Actor actor);
    public List<Actor>listar();
    public Actor modificarAct(Actor actor);
    public Actor buscar(int codigo);
    public boolean almacenarEnArchivo(Actor actor, String rutaArchivo) throws Exception;
    public List<Actor> recuperarDeArchivo(String rutaArchivo) throws Exception;
}
