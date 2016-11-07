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
public class Main {
    public static void main(String[] args) {
        try {
            Thread hilo = new Thread(new HiloImplements());
            hilo.start();
            hilo.join();
            System.out.println("holiiii");
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
