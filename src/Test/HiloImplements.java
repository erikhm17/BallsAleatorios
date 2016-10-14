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
public class HiloImplements implements Runnable {

    public HiloImplements() {
        super();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Hola mundo");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
