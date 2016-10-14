/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik
 */
public class Hilo implements Runnable {
    
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("hola 1");
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
