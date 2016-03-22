
package main;
import Afisare.Afisare;
import Citire.*;
import Gestiuni.Gestiuni;
import Magazine.*;
import Produse.Produse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String args[]) throws IOException{
        CitireProduse prod = new CitireProduse();
        CitireTaxe taxe = new CitireTaxe();
        CitireFactura factura = new CitireFactura();
        ArrayList<Magazin> magazine = new ArrayList<Magazin>();
        ArrayList<Produse> produse = new ArrayList<Produse>();
        Map<String,HashMap> taxe2 = new HashMap<String,HashMap>();
        
        prod.CitireProdus( new String("Surse\\Citire\\produse.txt") );
        taxe.CitireTaxe(new String("Surse\\Citire\\taxe.txt"));
        factura.CitireFactura(new String("Surse\\Citire\\facturi.txt"));
        magazine = factura.getVectorMagazine();
        produse = prod.getVectorProduse();
        taxe2 = taxe.getTaxe();
        for(Magazin i:magazine)
            for(int j = 0 ; j <i.getNumarFacturi() ; j++)
                for(int k = 0 ; k <i.getFactura(j).getNumarProduse(); k++){
                    if (i.getFactura(j).getProdus(k).verificarePret() == false)
                        for(Produse l : produse){
                            if( i.getFactura(j).getProdus(k).getDenumire().equals(l.getDenumire()) && i.getFactura(j).getProdus(k).getTara().equals(l.getTara()) ){
                                i.getFactura(j).getProdus(k).setPret(l.getPret());
                                i.getFactura(j).getProdus(k).setCategorie(l.getCategorie());
                            }
                        }
                    if(i.getFactura(j).getProdus(k).verificareTaxa() == false){
                        i.getFactura(j).getProdus(k).setTaxa((double) taxe2.get( i.getFactura(j).getProdus(k).getCategorie() ).get( i.getFactura(j).getProdus(k).getTara() ));
                    }
                }
      Gestiuni gestiune = Gestiuni.getGestiuniInstanta(magazine, produse, taxe2);
      Afisare.scriere(gestiune);
    }
}
