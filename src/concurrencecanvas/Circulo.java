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

    private Color color;
    /* default*/
    private int coordenadaX;
    private int coordenadaY;
    private JPanel panel;
    private Graphics graphics;
    private int index;
    private Semaforo semaforo;
    /* delay*/
    private int delay;

    /* vectores unitarios*/
    private int unitX;
    private int unitY;

    public Circulo(int index,
            Semaforo semaforo,
            JPanel panel,
            Graphics graphics,
            int coordenadaX,
            int coordenadaY,
            int delay,
            int unitX,
            int unitY,
            Color color
    ) {
        this.panel = panel;
        this.graphics = graphics;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.index = index;
        this.semaforo = semaforo;
        this.delay = delay;
        this.unitX = unitX;
        this.unitY = unitY;
        this.color = color;
        System.out.println("solo una vez");
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
            try {
                while (unitX > 0 && unitY > 0) {

                    coordenadaX = coordenadaX + 1;
                    coordenadaY = coordenadaY + 1;
                    Circulo.sleep(delay);
                    getPanel().repaint();
                    if (coordenadaY == 600 && coordenadaX != 1000 && unitX > 0) {
                        unitX = 1;
                        unitY = -1;
                    } else if (coordenadaX == 1000 && coordenadaY != 600 && unitY > 0) {
                        unitX = -1;
                        unitY = 1;

                    } else if (coordenadaX == 1000 && coordenadaY == 600) {
                        unitX = -1;
                        unitY = -1;
                    } else if (ingresoAlContenedor()) {
                        contar();
                        return;
                    }

                    /* caso especial */
                    chocaContenedor();

                }
                while (unitX > 0 && unitY < 0) {
                    coordenadaX = coordenadaX + 1;
                    coordenadaY = coordenadaY - 1;
                    Circulo.sleep(delay);
                    getPanel().repaint();
                    if (coordenadaY == 0 && coordenadaX != 1000 && unitX > 0) {
                        unitX = 1;
                        unitY = 1;
                    } else if (coordenadaY != 0 && coordenadaX == 1000 && unitY < 0) {
                        unitX = -1;
                        unitY = -1;
                    } else if (coordenadaX == 1000 && coordenadaY == 0) {
                        unitX = -1;
                        unitY = 1;
                    }
                    if (ingresoAlContenedor()) {
                        contar();
                        return;
                    }
                    chocaContenedor();

                }
                while (unitX < 0 && unitY < 0) {
                    coordenadaX = coordenadaX - 1;
                    coordenadaY = coordenadaY - 1;
                    Circulo.sleep(delay);
                    getPanel().repaint();
                    if (coordenadaY == 0 && coordenadaX != 0 && unitX < 0) {
                        unitX = -1;
                        unitY = 1;
                    } else if (coordenadaX == 0 && coordenadaY != 0 && unitY < 0) {
                        unitX = 1;
                        unitY = -1;
                    } else if (coordenadaX == 0 && coordenadaY == 0) {
                        unitX = 1;
                        unitY = 1;
                    }
                    if (ingresoAlContenedor()) {
                        contar();
                        return;
                    }
                    chocaContenedor();

                }
                while (unitX < 0 && unitY > 0) {
                    coordenadaX = coordenadaX - 1;
                    coordenadaY = coordenadaY + 1;
                    Circulo.sleep(delay);
                    getPanel().repaint();
                    if (coordenadaY != 600 && coordenadaX == 0 && unitY > 0) {
                        unitX = 1;
                        unitY = 1;

                    } else if (coordenadaY == 600 && coordenadaX == 0) {
                        unitX = 1;
                        unitY = -1;

                    } else if (coordenadaX != 1000 && coordenadaY == 600 && unitX < 0) {
                        unitX = -1;
                        unitY = -1;

                    }
                    if (ingresoAlContenedor()) {
                        contar();
                        return;
                    }
                    chocaContenedor();

                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    private int limiteX = 380;
    private int limiteY = 410;
    private void chocaContenedor() {
        /* si choca en las paredes del contenedor , debe rebotar*/
        if (coordenadaX == limiteX
                && coordenadaY >= limiteY
                && unitY > 0) {
            unitX = -1;
            unitY = 1;
        }
        if (coordenadaX == limiteX
                && coordenadaY >= limiteY
                && unitY < 0) {
            unitX = -1;
            unitY = -1;
        }
        if (coordenadaX == 600
                && coordenadaY >= limiteY
                && unitY > 0) {
            unitX = 1;
            unitY = 1;
        }
        if (coordenadaX == 600
                && coordenadaY >= limiteY
                && unitY < 0) {
            unitX = 1;
            unitY = -1;
        }

    }

    public boolean ingresoAlContenedor() {
        if (coordenadaX > limiteX && coordenadaX < (limiteX + 213)
                && coordenadaY > 450) {
            System.err.println("ingresó");
            return true;
        }
        return false;
    }

    public void contar() {
        if (ingresoAlContenedor()) {
            try {

                getSemaforo().Wait();
                Ventana.contador = Ventana.contador + 1;
                System.out.println("el circulo " + getIndex()
                        + " contó : " + Ventana.contador
                        + " Numero de pelota : " + Ventana.contador
                        + " indice : " + getIndex());
                Ventana.lblIngresaron.setText(String.valueOf(Ventana.contador));
                getSemaforo().Signal();
                /* para hacer desaparecer las pelotitas*/
                coordenadaX = 10000;
                coordenadaY = 10000;
                return;
            } catch (InterruptedException ex) {
                Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
