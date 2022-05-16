/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

/**
 *
 * @author varad
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Galeria galeria = new  Galeria();
        System.out.println("Címszerinti rendezés");
        for (KiallitasiTargy targy : galeria.rebdezCimszerint()) {
            System.out.println(targy);
        }
        
        for (KiallitasiTargy keszito : galeria.rendezKeszitoszerint()) {
            System.out.println(keszito);
        }
        
        for (KiallitasiTargy targy : galeria) {
            if (targy instanceof Festmeny) {
                ((Festmeny)targy).megjelenit();
            }
        }
        
        try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.bin"));
            objKi.writeObject(galeria);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        galeria = null;
        
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            galeria = (Galeria)objBe.readObject();
             
            objBe.close();
            
            System.out.println("Visszaállítás:");
            for (KiallitasiTargy targy : galeria) {
                System.out.println(targy);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
