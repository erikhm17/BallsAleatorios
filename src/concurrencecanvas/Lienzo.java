package concurrencecanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel {

    ArrayList<Circulo> arrayCirculo = new ArrayList<>();

    public Lienzo(JFrame frame) {
        initComponents();
        this.setSize(new Dimension(
                1100,
                700)
        );
        System.out.println("Lienzo solo una vez");
        /* llenando los objetos a una arreglo de circulos*/
        Semaforo mutex = new Semaforo(1);
        for (int i = 0; i < 30; i++) {
            arrayCirculo.add(new Circulo(i, mutex, this, null, 10, 10,(i+1*10)));
        }
        
    }

    @Override
    public void paint(Graphics g) {
        /* color del fondo*/
        g.setColor(new Color(246, 236, 236));
        /* tamaño del fondo*/
        g.fillRect(0, 0, getWidth(), getHeight());
        /* pintando los objetos */
        // System.out.println("tamaño arreglo: " + arrayCirculo.size());
        for (int i = 0; i < arrayCirculo.size(); i++) {
            arrayCirculo.get(i).setGraphics(g);
            g.setColor(arrayCirculo.get(i).getColor());

            g.fillOval(arrayCirculo.get(i).getCordenadaX(),
                    arrayCirculo.get(i).getCordenadaY(),
                    30,
                    30
            );
        }
        /* graficando el marco*/
        g.fillRect(0, 0, 2, 600);
        g.fillRect(0, 600, 1000, 2);
        g.fillRect(1000,0, 2, 600);
        g.fillRect(0,0, 1000, 2);
        
        g.fillRect(500, 400, 10, 140);
        //System.out.println("AAA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<Circulo> getArrayCirculo() {
        return arrayCirculo;
    }

    public void setArrayCirculo(ArrayList<Circulo> arrayCirculo) {
        this.arrayCirculo = arrayCirculo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
