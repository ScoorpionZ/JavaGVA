/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author varad
 */
public class Galeria  implements Iterable<KiallitasiTargy>, Serializable{
    private ArrayList<KiallitasiTargy> targyak;
    public  Galeria(){
        targyak= new ArrayList<>();
        try {
            Festmeny f1= new Festmeny("Kis Ede", "Táncoló virágok");
            
            Festmeny f2=new  Festmeny(LocalDate.now(), "Nagy Béla", "Susogó erdő");
            
            //Festmeny f3= new Festmeny(LocalDate.parse("2030-11-11"), "Tóth Dávid", "Vízpart");
            
            Festmeny f4= new Festmeny(new File("kep.txt"), "Varga János", "Madarak");
            
            Festmeny f5 =new  Festmeny(new File("kepek.txt"), LocalDate.now(), "Famusi Marcell", "Táncoló virágiok");
            
            targyak.add(f1);
            targyak.add(f2);
            //targyak.add(f3);
            targyak.add(f4);
            targyak.add(f5);
        } catch (HibasDatumException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void felvesz(KiallitasiTargy targy){
        targyak.add(targy);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return Collections.unmodifiableList(targyak).iterator();
    }
    
    public  List<KiallitasiTargy> rebdezCimszerint(){
        Collections.sort(targyak,KiallitasiTargy.cimrendez());
        return Collections.unmodifiableList(targyak);
    }
    
    public List<KiallitasiTargy> rendezKeszitoszerint(){
        Collections.sort(targyak,KiallitasiTargy.keszitorendezo());
        return Collections.unmodifiableList(targyak);
    }
}
