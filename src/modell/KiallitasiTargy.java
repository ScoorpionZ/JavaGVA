/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

class CimComparator implements Comparator<KiallitasiTargy>{

    @Override
    public int compare(KiallitasiTargy t, KiallitasiTargy t1) {
        Collator coll = Collator.getInstance();
        return coll.compare(t.getCim(), t1.getCim());
    }
    
}

class KeszitoComparator implements Comparator<KiallitasiTargy>{

    @Override
    public int compare(KiallitasiTargy k, KiallitasiTargy k1) {
        Collator coll2=Collator.getInstance();
        return coll2.compare(k.getKeszito(), k1.getKeszito());
    }

}

/**
 *
 * @author varad
 */
public abstract class KiallitasiTargy  implements Serializable{

    
    private LocalDate letrehozasDatum;
    private String keszito, cim;

    public KiallitasiTargy(String keszito, String cim) throws HibasDatumException {
        this.keszito = keszito;
        this.cim = cim;
        this.letrehozasDatum=LocalDate.now();
    }

    public KiallitasiTargy(LocalDate letrehozasDatum, String keszito, String cim) throws HibasDatumException {
        if (letrehozasDatum.isAfter(LocalDate.now())) {
            throw  new HibasDatumException("Nem létező dátum");
        }
        this.letrehozasDatum = letrehozasDatum;
        this.keszito = keszito;
        this.cim = cim;
    }

    public LocalDate getLetrehozasDatum() {
        return letrehozasDatum;
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }
    
   public static CimComparator cimrendez(){
       return new CimComparator();
   }
   
    public static KeszitoComparator keszitorendezo() {
        return new KeszitoComparator();
    }

    
}
