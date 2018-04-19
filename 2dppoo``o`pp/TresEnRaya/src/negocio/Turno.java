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
public class Turno {

    private boolean valor; // true (jugador1) y false (jugador2)

    public Turno(boolean valor) {
        this.valor = valor;
    }

    public boolean getValor() {
        return valor;
    }
    
    public void cambiar() {
        valor = !valor;
    }
}
