/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Actor;
import Modelo.Pelicula;
import Modelo.Personaje;
import Servicio.PersonajeServicio;
import java.util.List;

/**
 *
 * @author paulp
 */
public class PersonajeControl {
    
    Personaje pers;

    private final PersonajeServicio personajeServicio = new PersonajeServicio();
   
    public Personaje crear(int codigo,String [] params,Actor actor,Pelicula pelicula){
        var personaje = new Personaje(codigo,params[0],params[1],params[2],actor,pelicula); 
        this.personajeServicio.crear(personaje);
        return personaje;
    }
   
    public List<Personaje> listar()
    {
        return this.personajeServicio.listar();
    }
    
    public void modificar(int codigo,String [] params,Actor actor,Pelicula pelicula) {

        for (int i = 0; i < this.listar().size(); i++) {
            if (codigo == this.listar().get(i).getCodigo()) {//params[0].equals(this.listar().get(i).getCodigo())
                var pers = new Personaje(codigo,params[0], params[1], params[2],actor, pelicula);
                pers.setNombrePer(params[0]);
                pers.setFuncionPer(params[1]);
                pers.setGeneroMof(params[2]);
                pers.setActor(actor);
                pers.setPelicula(pelicula);
                personajeServicio.modificarPer(pers);
            }
        }
    }
    
    public void eliminar(int codigo) {

        this.personajeServicio.eliminar(codigo);
    }

}
