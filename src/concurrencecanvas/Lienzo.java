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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Erik
 */
public class Lienzo extends javax.swing.JPanel {

    int x = getWidth() / 2;
    int getWidth = getWidth();

    public Lienzo(JFrame frame) {
        initComponents();
        this.setSize(new Dimension(
                frame.getWidth(),
                frame.getHeight())
        );

    }

    @Override
    public void paint(Graphics g) {
        /* color del fondo*/
        g.setColor(new Color(246, 236, 236));
        /* tamaño del fondo*/
        g.fillRect(0, 0, getWidth(), getHeight());

        Circulo c = new Circulo(30, Color.blue, 10, 50, this,g);
        c.repintarCirculo();
        
//        /* poniendo circulos*/
//        ArrayList<Circulo> circulos = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Circulo c = new Circulo(10, Color.blue, i * 10, 50, this);
//            circulos.add(c);
//        }
//        for (Circulo c : circulos) {
//            g.setColor(c.getColor());
//            g.fillOval(
//                    c.getCordenadaX(),
//                    c.getCordenadaY(),
//                    c.getRadio(),
//                    c.getRadio()
//            );
//        }
//        
//        /*repintar un objeto*/
//        circulos.get(2).setColor(Color.yellow);
//        g.setColor(circulos.get(2).getColor());
//        g.fillOval(circulos.get(2).getCordenadaX(),
//                circulos.get(2).getCordenadaY(),
//                circulos.get(2).getRadio(),circulos.get(2).getRadio());
//        
//        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
