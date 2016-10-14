package concurrencecanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    Color color = Color.BLUE;
    int coordenadaX = 50;
    int coordenadaY = 50;

    public Lienzo(JFrame frame) {
        initComponents();
        this.setSize(new Dimension(
                frame.getWidth(),
                frame.getHeight())
        );
        System.out.println("Lienzo solo una vez");

    }

    @Override
    public void paint(Graphics g) {
        /* color del fondo*/
        g.setColor(new Color(246, 236, 236));
        /* tamaño del fondo*/
        g.fillRect(0, 0, getWidth(), getHeight());

        /* pintando el circulo*/
        g.setColor(color);
        g.fillOval(coordenadaX, coordenadaY, 30, 30);
        
        g.setColor(color);
        g.fillOval(coordenadaX+50, coordenadaY+50, 30, 30);
        
        System.out.println("AAA");
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

    @Override
    public void run() {
        
        while (true) {
            try {

                /* objeto circulo*/
                Thread.sleep(300);
                color = Color.GRAY;
                coordenadaX = coordenadaX+20;
                
                repaint();

                System.out.println("---");
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
