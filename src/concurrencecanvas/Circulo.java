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
    private int x;
    private int y;
    private int getWith;
    private JPanel panel;

    public Circulo(int radio, Color color, int x, int y, JPanel panel) {
        this.radio = radio;
        this.color = color;
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPanelAncho() {
        return getWith;
    }

    public void setPanelAncho(int panelAncho) {
        this.getWith = panelAncho;
    }

    public int getPanelAlto() {
        return getWith;
    }

    public void setPanelAlto(int getWith) {
        this.getWith = getWith;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void repintarCirculo() {
        this.panel.repaint();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (x < getWith - 30) {
                    Thread.sleep(50);
                    x += 10;
                    repintarCirculo();
                }
                while (x > 10) {
                    Thread.sleep(50);
                    x -= 10;
                    repintarCirculo();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
