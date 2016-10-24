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
        Semaforo mutex = new Semaforo(1); /* con uno para que el wait consuma, y lo redusca a 0*/
        ArrayList<Color> colores = new ArrayList<>();
        colores.add(Color.BLACK);
        colores.add(Color.BLUE);
        colores.add(Color.YELLOW);
        colores.add(Color.CYAN);
        colores.add(Color.DARK_GRAY);
        colores.add(Color.GREEN);
        colores.add(Color.LIGHT_GRAY);
        colores.add(Color.ORANGE);
        colores.add(Color.RED);
        
        int bolaPorEsquina = 10;
        /* arriba derecha*/
        for (int i = 0; i < bolaPorEsquina; i++) {
            Color colorAleatorio = colores.get((int) (Math.random() * colores.size()));
            arrayCirculo.add(new Circulo(
                    i,
                    mutex,
                    this,
                    null,
                    50,50*i,3,1,1,colorAleatorio)
            );
        }
        /*arriba izquierda*/
        for (int i = 0; i < bolaPorEsquina; i++) {
            Color colorAleatorio = colores.get((int) (Math.random() * colores.size()));
            arrayCirculo.add(new Circulo(
                    i,
                    mutex,
                    this,
                    null,
                    1000-i*50,0,3,-1,1,colorAleatorio)
            );
        }
        /* abajo derecha*/
        for (int i = 0; i < bolaPorEsquina; i++) {
            Color colorAleatorio = colores.get((int) (Math.random() * colores.size()));
            arrayCirculo.add(new Circulo(
                    i,
                    mutex,
                    this,
                    null,
                    1000,600+i*50,3,-1,-1,colorAleatorio)
            );
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
//        g.fillRect(0, 0, 2, 600);
//        g.fillRect(0, 600, 1000, 2);
//        g.fillRect(1000, 0, 2, 600);
//        g.fillRect(0, 0, 1000, 2);

        g.setColor(Color.BLACK);
        g.fillRect(400, 450, 10, 200);
        g.fillRect(610, 450, 10, 200);
        g.fillRect(400, 650, 220, 10);
        

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
