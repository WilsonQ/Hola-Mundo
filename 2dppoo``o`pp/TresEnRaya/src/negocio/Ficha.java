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
public class Ficha {
    public static final short TAM_PIXELES = 128;
    private char valor;
    public Ficha(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }    

}
