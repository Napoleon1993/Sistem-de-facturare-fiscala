
package Magazine;

import Facturi.Factura;


public class HyperMarket extends Magazin{
     private static final String tip = "HyperMarket";
    public String getTip(){
        return tip;
    }

    @Override
    public double calculScutiriTaxe() {
       for ( Factura i : facturi ){
           if(i.getTotalcuTaxe() >= this.getTotalCuTaxe()/10)
               return 1;
       }
       return 0;
    }
}
