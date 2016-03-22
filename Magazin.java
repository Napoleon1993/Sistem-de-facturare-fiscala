
package Magazine;

import Facturi.Factura;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Magazin implements IMagazin{
    private String nume;
    private int numarFacturi;
    protected ArrayList<Factura> facturi = new ArrayList<Factura>();
    
    public void setFactura(Factura factura){
        facturi.add(factura);
    }
    
    public Factura getFactura(int i){
        return facturi.get(i);
    }
    
    public ArrayList<Factura> getListaFacturi(){
        return facturi;
    }
    
    public void sortareFacturi(){
        Collections.sort(facturi,new Comparator<Factura>(){
            public int compare(Factura factura1 , Factura factura2){
                    return Double.compare(factura1.getTotalcuTaxe(), factura2.getTotalcuTaxe());
            } 
        });
    }
    
    public void setNume(String nume){
        this.nume = nume;
    }
    public String getNume(){
        return nume;
    }
    
    public void setNumarFacturi(int numar){
        numarFacturi = numar;
    }
    public int getNumarFacturi(){
        return numarFacturi;
    }
    
    public double getTotalFaraTaxe(){
        double suma = 0;
        for(Factura i : facturi)
            suma += i.getTotalfaraTaxe();
        return suma;
    }

    @Override
    public double getTotalCuTaxe() {
        double suma = 0;
        for(Factura i : facturi)
            suma += i.getTotalcuTaxe();
        return suma;
    }

    @Override
    public double getTotalCuTaxeScutite() {
        double suma = 0 ;
        suma =this.getTotalCuTaxe() -  this.getTotalCuTaxe() * this.calculScutiriTaxe()/100;
        return suma;
        
    }

    @Override
    public double getTotalTaraFaraTaxe(String tara) {
        double suma = 0;
        for(Factura i : facturi)
            suma += i.getTotalTarafaraTaxe(tara);
        return suma;
    }

    @Override
    public double getTotalTaraCuTaxe(String tara) {
        double suma = 0;
        for(Factura i : facturi)
            suma += i.getTotalTaraCuTaxe(tara);
        return suma;
    }

    @Override
    public double getTotalTaraCuTaxeScutite(String tara) {
        double suma = 0;
            suma =this.getTotalTaraCuTaxe(tara) - this.getTotalTaraCuTaxe(tara) * this.calculScutiriTaxe()/100;
        return suma;
    }
    
    public abstract double calculScutiriTaxe();
    
    public String toString(){
        String s = ""+nume+" contine " + numarFacturi+" facturi\n";
        for(Factura i:facturi)
            s += i.toString();
        return s;
    }
}
