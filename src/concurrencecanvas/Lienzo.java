/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencecanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    int x = getWidth() / 2;
    int getWidth = getWidth();
    Graphics graphics;
    Circulo c;
    private Color color;
    
    public Lienzo(JFrame frame) {
        initComponents();
        this.setSize(new Dimension(
                frame.getWidth(),
                frame.getHeight())
        );
        color = Color.RED;
    }

    @Override
    public void paint(Graphics g) {
        graphics = g;
        /* color del fondo*/
        graphics.setColor(new Color(246, 236, 236));
        /* tamaño del fondo*/
        graphics.fillRect(0, 0, getWidth(), getHeight());
        c = new Circulo(30, color, 10, 50, this, graphics);
        c.repintarCirculo();
        
        System.out.println("Solo una vez");
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
        try {
            while (true) {
                System.out.println("Canvas actualizando");
                Thread.sleep(2000);
                color = Color.GREEN;
                c.repintarCirculo();
                this.repaint();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
