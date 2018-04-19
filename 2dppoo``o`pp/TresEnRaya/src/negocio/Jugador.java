/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author CrysMario
 */
public class Jugador {
    private String nombre;
    private Turno turno;
    private Ficha ficha;

    public Jugador(String nombre, Turno turno, Ficha ficha) {
        this.nombre = nombre;
        /* Recordemos si el valor de turno es 1 entonces es jugador1
           y si el valor de turno es -1 entonces es jugador2
        */
        this.turno = turno;
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
   
}
