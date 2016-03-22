
package Gestiuni;

import Magazine.Magazin;
import Produse.Produse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestiuni {
    public ArrayList<Produse> produse = new ArrayList<Produse>();
    public ArrayList<Magazin> magazine = new ArrayList<Magazin>();
    public Map<String,HashMap> taxe = new HashMap<String , HashMap>();
    private static Gestiuni instanta = null;
    private Gestiuni(ArrayList<Magazin> m , ArrayList<Produse> p , Map<String , HashMap> t ){
        magazine = m;
        produse = p;
        taxe = t;
    };
    public static Gestiuni getGestiuniInstanta( ArrayList<Magazin> m , ArrayList<Produse> p , Map<String , HashMap> t ){
        if ( instanta == null )
            return new Gestiuni( m , p , t );
        return instanta;
    } 
}
