
package Facturi;

import Produse.Produse;
import Produse.ProduseComandate;
import java.util.ArrayList;


public class Factura {
    private ArrayList<ProduseComandate> produs = new ArrayList<ProduseComandate>();
    private int numarProduse;
    private String numeFactura;
    
    public void setNumeFactura(String nume){
        numeFactura = nume;
    }
    public String getNumeFactura(){
        return numeFactura;
    }
    
    public void setNumarProduse(int numarProduse){
        this.numarProduse = numarProduse;
    }
    public int getNumarProduse(){
        return numarProduse;
    }
    
    public void setProdusComandat(ProduseComandate p){
        produs.add(p);
    }
    public ProduseComandate getProdus(int i){
        return produs.get(i);
    }
    
    public double getTotalfaraTaxe(){
        double suma = 0;
        for (ProduseComandate i:produs)
            suma += i.getCantitate() * i.getPret();
    return suma;
    }
    public double getTotalcuTaxe(){
        double suma = 0;
        for(ProduseComandate i:produs)
            suma += i.getCantitate() * i.getPret() + i.getCantitate() * i.getPret() * i.getTaxa()/100;
        return suma;
    } 
    public double getTaxe(){
        double suma = 0;
        suma = this.getTotalcuTaxe() - this.getTotalfaraTaxe();
        return suma;
    }
    
    public double getTotalTarafaraTaxe(String t){
        double suma = 0;
        for (ProduseComandate i:produs)
            if(i.getTara().equals(t))
                suma += i.getCantitate()*i.getPret();
        return suma;
    }
    public double getTotalTaraCuTaxe(String t){
        double suma = 0;
        for (ProduseComandate i:produs)
            if(i.getTara().equals(t))
                suma += i.getCantitate()*i.getPret() + i.getCantitate()*i.getPret()*i.getTaxa()/100 ;
        return suma;
    }
    public double getTaxeTara(String t){
        double suma = 0;
        suma = this.getTotalTaraCuTaxe(t) - this.getTotalTarafaraTaxe(t);
        return suma;
    }
    
    public double getTotalCategorie(String categorie){
        double suma = 0 ;
        for(int  i = 0 ; i < numarProduse ; i++)
            if( this.getProdus(i).getCategorie().equals(categorie) ) {
                suma += this.getProdus(i).getCantitate() * this.getProdus(i).getPret() + this.getProdus(i).getCantitate() * this.getProdus(i).getPret() * this.getProdus(i).getTaxa()/100;
            }
        return suma ;
    }
    
    public String toString(){
        String s ="\t" + numeFactura + " contine "+numarProduse+" produse\n" ;
        for (ProduseComandate i : produs)
            s += i.toString();
        return s;
    }
}
