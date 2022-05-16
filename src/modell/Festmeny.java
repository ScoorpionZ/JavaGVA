/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author varad
 */
public class Festmeny extends KiallitasiTargy{
     private  File eleresiut;

    public Festmeny(String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"),keszito, cim);
    }

     
    public Festmeny(File eleresiut, String keszito, String cim) throws HibasDatumException {
        this(eleresiut,LocalDate.now(),keszito, cim);

    }

    public Festmeny(LocalDate letrehozasDatum, String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"),letrehozasDatum, keszito, cim);
    }
    

    public Festmeny(File eleresiut, LocalDate letrehozasDatum, String keszito, String cim) throws HibasDatumException {
        super(letrehozasDatum, keszito, cim);
        this.eleresiut = eleresiut;
    }
    
    public  void megjelenit(){
        if (eleresiut.exists()) {
            System.out.println("megjelenítés folyamatban…");
        }
        else{
             System.out.println("nem lehet megjeleníteni!");
        }
    }
     
     
}
