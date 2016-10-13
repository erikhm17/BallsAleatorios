/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencecanvas;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Erik
 */
public class Circulo implements Runnable {

    private int radio;
    private Color color;
    private int cordenadaX;
    private int cordenadaY;
    private JPanel panel;

    public Circulo(int radio, Color color, int cordenadaX, int cordenadaY, JPanel panel) {
        this.radio = radio;
        this.color = color;
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
        this.panel = panel;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public int getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(int cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        try {
            cordenadaX = +10;
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
