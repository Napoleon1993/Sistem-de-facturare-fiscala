
package Magazine;
import Facturi.*;
import Produse.*;
import Citire.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MiniMarket extends Magazin{
    private static final String tip = "Minimarket";
    public String getTip(){
        return tip;
    }

    public double calculScutiriTaxe() {
        CitireProduse produs = new CitireProduse();
        try {
             produs.CitireProdus( new String("D:\\Aplicatii java\\TemaPOO\\JavaApplication31\\src\\Citire\\produse.txt") );
         } catch (IOException ex) {
             Logger.getLogger(MediumMarket.class.getName()).log(Level.SEVERE, null, ex);
         }
        ArrayList<Produse> pr = new ArrayList<Produse>();
        pr = produs.getVectorProduse();
        for(Produse i : pr)
                if(super.getTotalCuTaxe()*1/2 <= super.getTotalTaraCuTaxe(i.getTara()))
                    return 10;
        return 0;        
    }
}
