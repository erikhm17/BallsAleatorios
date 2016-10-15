/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencecanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Erik
 */
public final class Circulo extends Thread {

    private Color color = Color.BLUE;
    /* default*/
    private int coordenadaX;
    private int coordenadaY;
    private JPanel panel;
    private Graphics graphics;

    public Circulo(JPanel panel, Graphics graphics, int coordenadaX, int coordenadaY) {
        this.panel = panel;
        this.graphics = graphics;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        System.out.println("solo una vez");
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    public int getCordenadaX() {
        return coordenadaX;
    }

    public void setCordenadaX(int cordenadaX) {
        this.coordenadaX = cordenadaX;

    }

    public int getCordenadaY() {
        return coordenadaY;
    }

    public void setCordenadaY(int cordenadaY) {
        this.coordenadaY = cordenadaY;

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void repintarCirculo() {
        getGraphics().setColor(getColor());
        getGraphics().fillOval(getCordenadaX(),
                getCordenadaY(),
                10, /* medidas x default*/
                10
        );

        //System.out.println("repintando : " + getCordenadaX() +" color : "+getColor());
    }

    @Override
    public void run() {
        while (true) {
            System.err.println(getPanel().getWidth());
            try {
                
                System.err.println(getPanel().getWidth());
                System.err.println(getCordenadaX());
                System.err.println(getCordenadaY());
                while (coordenadaX < 900 || coordenadaY < 500) {
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(100);
                    getPanel().repaint();
                }
                while (coordenadaX > 9 || coordenadaY > 9) {
                    coordenadaX = (int) (coordenadaX - Math.random() * 10);
                    coordenadaY = (int) (coordenadaY - Math.random() * 10);
                    Circulo.sleep(100);
                    getPanel().repaint();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
