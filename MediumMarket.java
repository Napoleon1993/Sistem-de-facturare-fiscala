
package Magazine;

import Citire.CitireProduse;
import Facturi.Factura;
import Produse.Produse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MediumMarket extends Magazin {
     private static final String tip = "MediumMarket";
    public String getTip(){
        return tip;
    }
  
    @Override
    public double calculScutiriTaxe() {
        double suma = 0 ;
        CitireProduse produs = new CitireProduse();
         try {
             produs.CitireProdus( new String("D:\\Aplicatii java\\TemaPOO\\JavaApplication31\\src\\Citire\\produse.txt") );
         } catch (IOException ex) {
             Logger.getLogger(MediumMarket.class.getName()).log(Level.SEVERE, null, ex);
         }
        ArrayList<Produse> pr = new ArrayList<Produse>();
        pr = produs.getVectorProduse();
        for(int j = 0 ; j < pr.size(); j++){
            suma = 0;
            for(Factura i : facturi)
                suma = suma + i.getTotalCategorie(pr.get(j).getCategorie());
            if(suma >= super.getTotalCuTaxe()/2)
                return 5;
        }
        return 0;
    }
}
