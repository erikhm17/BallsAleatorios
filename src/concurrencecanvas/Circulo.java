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
    private int index;
    private Semaforo semaforo;
    /* delay*/
    private int delay;

    public Circulo(int index,
            Semaforo semaforo,
            JPanel panel,
            Graphics graphics,
            int coordenadaX,
            int coordenadaY,
            int delay) {
        this.panel = panel;
        this.graphics = graphics;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.index = index;
        this.semaforo = semaforo;
        this.delay = delay;
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
    /* banderas */
 /* si choca arriba*/
    private boolean flagtop = false;
    /* si choca abajo*/
    private boolean flagBottom = false;
    /* si choca a la izquierda*/
    private boolean flagLeft = false;
    /* si choca a la derecha*/
    private boolean flagRight = false;

    @Override
    public void run() {
        while (true) {
//            System.err.println("ancho de la ventana " + getPanel().getWidth());
            try {
                flagActivate();
//                System.out.println("Coordenadas : " + coordenadaX + " , " + coordenadaY);
//                System.out.println("bottom: " + flagBottom + "\n"
//                        + " left: " + flagLeft + "\n"
//                        + " right: " + flagRight + "\n"
//                        + " top: " + flagtop + "\n"
//                );
                /* si choca solo arriba */
                while (!flagBottom && !flagLeft && !flagRight && flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* si choca arriba y a la izquierda (esquina)*/
                while (!flagBottom && flagLeft && !flagRight && flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* si choca arriba y a la derecha (esquina)*/
                while (!flagBottom && !flagLeft && flagRight && flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* solo chocó abajo */
                while (flagBottom && !flagLeft && !flagRight && !flagtop) {

//                    if (flagBottom) {
//                        //System.out.println("#### 1 : " + getIndex());
//                        getSemaforo().Wait();
//                        Ventana.contador = Ventana.contador + 1;
//                        System.out.println("el circulo " + getIndex()
//                                + " contó : " + Ventana.contador
//                                + " Numero de pelota : " + Ventana.contador
//                                + " indice : " + getIndex());
//                        getSemaforo().Signal();
//                        //System.out.println("#### 2 : " + getIndex());
//                        return;
//                    }

                    flagActivate();
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY - Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* solo chocó abajo izquierda (esquina)*/
                while (flagBottom && flagLeft && !flagRight && !flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX + Math.random() * 10);
                    coordenadaY = (int) (coordenadaY - Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* solo chocó abajo derecha (esquina)*/
                while (flagBottom && !flagLeft && flagRight && !flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX - Math.random() * 10);
                    coordenadaY = (int) (coordenadaY - Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* chocó a la derecha*/
                while (!flagBottom && !flagLeft && flagRight && !flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX - Math.random() * 10);
                    coordenadaY = (int) (coordenadaY - Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* chocó arriba y a  la derecha*/
                while (!flagBottom && !flagLeft && flagRight && flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX - Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }
                /* chocó a la izquierda */
                while (!flagBottom && flagLeft && !flagRight && !flagtop) {
                    flagActivate();
                    coordenadaX = (int) (coordenadaX - Math.random() * 10);
                    coordenadaY = (int) (coordenadaY + Math.random() * 10);
                    Circulo.sleep(delay);
                    getPanel().repaint();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Circulo.class.getName()).log(Level.SEVERE, null, ex);
            }
            refhresh(false);
        }
    }

    private synchronized void refhresh(boolean flag) {
        flagtop = flag;
        flagBottom = flag;
        flagLeft = flag;
        flagRight = flag;
        System.out.println("Refrescado");

    }

    /* si el objeto llegó al limite Y*/
    public synchronized void flagActivate() {
        /* el que valida que banderas se activan*/

 /* si choca abajo*/
        if (coordenadaY >= 500 && coordenadaY <= 600) {
            flagBottom = true;

        }
        /* si choca arriba*/
        if (coordenadaY <= 50 && coordenadaY >= 0) {
            flagtop = true;

        }
        /* si choca en la derecha */
        if (coordenadaX >= 900 && coordenadaX <= 1000) {
            flagRight = true;

        }
        if (coordenadaX <= 50 && coordenadaX >= 0) {
            flagLeft = true;

        }

    }
}
