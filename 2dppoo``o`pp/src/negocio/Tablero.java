/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author CrysMario
 */
public class Tablero extends Canvas implements MouseListener {

    public static final byte MAX = 3;
    private Ficha[][] casillas;
    private Color fondoCasilla;
    private Color fichaX;
    private Color fichaO;
    private Color rejillas;
    private Jugador jug1;
    private Jugador jug2;

    public Tablero() {
        super();
        casillas = new Ficha[MAX][MAX];
        fondoCasilla = Color.white;
        fichaX = Color.red;
        fichaO = Color.blue;
        rejillas = Color.black;
        jug1 = new Jugador("Anónimo1", new Turno(true), new Ficha('x'));
        jug2 = new Jugador("Anónimo2", new Turno(false), new Ficha('o'));

        setSize(Ficha.TAM_PIXELES * 3, Ficha.TAM_PIXELES * 3);
        //setLocation(10, 10);
        //setBounds(10, 10, 100, 100);
        //setBackground(Color.cyan);
        addMouseListener(this);
    }

    public Ficha getCasilla(byte f, byte c) {
        return casillas[f][c];
    }

    public void setCasilla(byte f, byte c, Ficha ch) {
        casillas[f][c] = ch;
    }

    public Color getFondoCasilla() {
        return fondoCasilla;
    }

    public Color getFichaX() {
        return fichaX;
    }

    public Color getFichaO() {
        return fichaO;
    }

    public Color getRejillas() {
        return rejillas;
    }

    public Jugador getJugador1() {
        return jug1;
    }

    public Jugador getJugador2() {
        return jug2;
    }

    public void setFondoCasilla(Color fondoCasilla) {
        this.fondoCasilla = fondoCasilla;
    }

    public void setFichaX(Color fichaX) {
        this.fichaX = fichaX;
    }

    public void setFichaO(Color fichaO) {
        this.fichaO = fichaO;
    }

    public void setRejillas(Color rejillas) {
        this.rejillas = rejillas;
    }

    public void setJugador1(Jugador jug1) {
        this.jug1 = jug1;
    }

    public void setJugador2(Jugador jug2) {
        this.jug2 = jug2;
    }

    public void inicializar() {
        //jug1 = new Jugador("Anónimo1", new Turno(true), new Ficha('x'));
        //jug2 = new Jugador("Anónimo2", new Turno(false), new Ficha('o'));
        jug1.setTurno(new Turno(true));
        jug1.setFicha(new Ficha('x'));
        jug2.setTurno(new Turno(false));
        jug2.setFicha(new Ficha('o'));
        for (byte i = 0; i < MAX; i++) {
            for (byte j = 0; j < MAX; j++) {
                casillas[i][j] = new Ficha('v');
            }
        }
        /*
         'v' = ficha vacía
         'x' = ficha X
         'o' = ficha O
         */
        repaint();
    }

    public boolean esEmpate() {
        boolean sw = true;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (casillas[i][j].getValor() == 'v') {
                    sw = false;
                }
            }
        }
        return sw;
    }

    public boolean esVictoria(Jugador jug) {
        boolean sw = false;
        // Búsqueda de ganador por filas
        for (int i = 0; i < MAX; i++) {
            byte count = 0;
            for (int j = 0; j < MAX; j++) {
                count += (casillas[i][j].getValor() == jug.getFicha().getValor()) ? 1 : 0;
            }
            if (count == 3) {
                sw = true;
            }
        }
        // Búsqueda de ganador por columnas
        for (int j = 0; j < MAX; j++) {
            byte count = 0;
            for (int i = 0; i < MAX; i++) {
                count += (casillas[i][j].getValor() == jug.getFicha().getValor()) ? 1 : 0;
            }
            if (count == 3) {
                sw = true;
            }
        }
        // Búsqueda de ganador en diagonales
        if (casillas[0][0].getValor() == jug.getFicha().getValor()
                && casillas[1][1].getValor() == jug.getFicha().getValor()
                && casillas[2][2].getValor() == jug.getFicha().getValor()) {
            sw = true;
        }
        if (casillas[0][2].getValor() == jug.getFicha().getValor()
                && casillas[1][1].getValor() == jug.getFicha().getValor()
                && casillas[2][0].getValor() == jug.getFicha().getValor()) {
            sw = true;
        }

        return sw;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (byte i = 0; i < MAX; i++) {
            for (byte j = 0; j < MAX; j++) {
                if (casillas[i][j].getValor() == 'v') {
                    g.setColor(fondoCasilla);
                    g.fillRect(j * Ficha.TAM_PIXELES, i * Ficha.TAM_PIXELES, Ficha.TAM_PIXELES, Ficha.TAM_PIXELES);
                } else if (casillas[i][j].getValor() == 'x') {
                    g.setColor(fondoCasilla);
                    g.fillRect(j * Ficha.TAM_PIXELES, i * Ficha.TAM_PIXELES, Ficha.TAM_PIXELES, Ficha.TAM_PIXELES);
                    g.setColor(fichaX);
                    g.setFont(new Font("Courier", Font.BOLD, 60));
                    g.drawString("X", j * Ficha.TAM_PIXELES + 42, i * Ficha.TAM_PIXELES + 80);
                } else if (casillas[i][j].getValor() == 'o') {
                    g.setColor(fondoCasilla);
                    g.fillRect(j * Ficha.TAM_PIXELES, i * Ficha.TAM_PIXELES, Ficha.TAM_PIXELES, Ficha.TAM_PIXELES);
                    g.setColor(fichaO);
                    g.setFont(new Font("Arial", Font.BOLD, 60));
                    g.drawString("O", j * Ficha.TAM_PIXELES + 42, i * Ficha.TAM_PIXELES + 80);
                }
                g.setColor(rejillas);
                g.fillRoundRect(Ficha.TAM_PIXELES - 3, 0, 6, Ficha.TAM_PIXELES * 3, 7, 7);
                g.fillRoundRect(Ficha.TAM_PIXELES * 2 - 3, 0, 6, Ficha.TAM_PIXELES * 3, 7, 7);
                g.fillRoundRect(0, Ficha.TAM_PIXELES - 3, Ficha.TAM_PIXELES * 3, 6, 7, 7);
                g.fillRoundRect(0, Ficha.TAM_PIXELES * 2 - 3, Ficha.TAM_PIXELES * 3, 6, 7, 7);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        byte f = (byte) (e.getY() / Ficha.TAM_PIXELES);
        byte c = (byte) (e.getX() / Ficha.TAM_PIXELES);

        if (jug1.getTurno().getValor() && casillas[f][c].getValor() == 'v') {
            casillas[f][c] = jug1.getFicha();
            jug1.getTurno().cambiar();
            jug2.getTurno().cambiar();
            repaint();
            if (esVictoria(jug1)) {
                JOptionPane.showMessageDialog(this, jug1.getNombre() + " ganó la partida.");
                inicializar();
            } else if (esEmpate()) {
                JOptionPane.showMessageDialog(this, "Empate técnico");
            }
        } else if (jug2.getTurno().getValor() && casillas[f][c].getValor() == 'v') {
            casillas[f][c] = jug2.getFicha();
            jug1.getTurno().cambiar();
            jug2.getTurno().cambiar();
            repaint();
            if (esVictoria(jug2)) {
                JOptionPane.showMessageDialog(this, jug2.getNombre() + " ganó la partida.");
                inicializar();
            } else if (esEmpate()) {
                JOptionPane.showMessageDialog(this, "Empate técnico");
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
