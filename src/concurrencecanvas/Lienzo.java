/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencecanvas;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    int x = getWidth() / 2;
    Thread hilo;
    public Lienzo() {
        initComponents();
        /* lo inicializamos al crear nuestro lienzo*/
        hilo = new Thread(this); 
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillOval(x, getHeight() / 2, 30, 30);

    }
    public void inicio(){
        hilo.start();
    }
    public void pausa(){
        hilo.suspend();
    }
    public void continuar(){
        hilo.resume();
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
                while (x < getWidth() - 30) {
                    Thread.sleep(50);
                    x += 10;
                    repaint();
                }
                while (x > 10) {
                    Thread.sleep(50);
                    x -= 10;
                    repaint();
                }

            }
        } catch (Exception e) {
            System.out.println("ocurrio un error");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
