
package Afisare;

import Facturi.Factura;
import Gestiuni.Gestiuni;
import Magazine.Magazin;
import java.util.ArrayList;
import java.util.*;
import Magazine.*;
import Produse.Produse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Afisare {
    public static void scriere(Gestiuni gestiune) throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter(new FileOutputStream("Surse\\Citire\\out.txt", false));
        Collections.sort(gestiune.magazine,new Comparator<Magazin>(){
            public int compare(Magazin magazin1 , Magazin magazin2){
                return Double.compare(magazin1.getTotalCuTaxe(), magazin2.getTotalCuTaxe());
            } 
    });
        ArrayList<Factura> facturi = null;
        writer.println("MiniMarket");
        for(Magazin i : gestiune.magazine)
            if(i instanceof MiniMarket){
                writer.println(i.getNume()+System.getProperty("line.separator"));
                writer.print("Total ");
                writer.printf("%.2f %.2f %.2f", i.getTotalFaraTaxe(),i.getTotalCuTaxe(),i.getTotalCuTaxeScutite());
                writer.println(System.getProperty("line.separator"));
                writer.println("Tara");
                for(int j = 0 ; j < Produse.getNumarTari();j++){
                    String tara = gestiune.produse.get(j).getTara();
                    writer.print(tara + " ");
                    writer.printf("%.2f %.2f %.2f", i.getTotalTaraFaraTaxe(tara) , i.getTotalTaraCuTaxe(tara) , i.getTotalTaraCuTaxeScutite(tara));
                    writer.println();
                }
                i.sortareFacturi();
                facturi = new ArrayList<Factura>();
                facturi = i.getListaFacturi();
                writer.println();
                for(Factura j : facturi){
                    writer.println(j.getNumeFactura()+System.getProperty("line.separator"));
                    writer.printf("Total %.2f %.2f",j.getTotalfaraTaxe(),j.getTotalcuTaxe());
                    writer.println(System.getProperty("line.separator"));
                    writer.println("Tara");
                    for(int k = 0 ; k < Produse.getNumarTari();k++){
                        String tara = j.getProdus(k).getTara();
                        writer.print(tara + " ");
                        writer.printf("%.2f %.2f",j.getTotalTarafaraTaxe(tara),j.getTotalTaraCuTaxe(tara));
                        writer.println();
                    }
                    writer.println();
                }
            }
        writer.println("MediumMarket");
        for(Magazin i : gestiune.magazine)
            if(i instanceof MediumMarket){
                writer.println(i.getNume()+System.getProperty("line.separator"));
                writer.print("Total ");
                writer.printf("%.2f %.2f %.2f", i.getTotalFaraTaxe(),i.getTotalCuTaxe(),i.getTotalCuTaxeScutite());
                writer.println(System.getProperty("line.separator"));
                writer.println("Tara");
                for(int j = 0 ; j < Produse.getNumarTari();j++){
                    String tara = gestiune.produse.get(j).getTara();
                    writer.print(tara + " ");
                    writer.printf("%.2f %.2f %.2f", i.getTotalTaraFaraTaxe(tara) , i.getTotalTaraCuTaxe(tara) , i.getTotalTaraCuTaxeScutite(tara));
                    writer.println();
                }
                i.sortareFacturi();
                facturi = new ArrayList<Factura>();
                facturi = i.getListaFacturi();
                writer.println();
                for(Factura j : facturi){
                    writer.println(j.getNumeFactura()+System.getProperty("line.separator"));
                    writer.printf("Total %.2f %.2f",j.getTotalfaraTaxe(),j.getTotalcuTaxe());
                    writer.println(System.getProperty("line.separator"));
                    writer.println("Tara");
                    for(int k = 0 ; k < Produse.getNumarTari();k++){
                        String tara = j.getProdus(k).getTara();
                        writer.print(tara + " ");
                        writer.printf("%.2f %.2f",j.getTotalTarafaraTaxe(tara),j.getTotalTaraCuTaxe(tara));
                        writer.println();
                    }
                    writer.println();
                }
            }
        writer.println("HyperMarket");
        for(Magazin i : gestiune.magazine)
            if(i instanceof HyperMarket){
                writer.println(i.getNume()+System.getProperty("line.separator"));
                writer.print("Total ");
                writer.printf("%.2f %.2f %.2f", i.getTotalFaraTaxe(),i.getTotalCuTaxe(),i.getTotalCuTaxeScutite());
                writer.println(System.getProperty("line.separator"));
                writer.println("Tara");
                for(int j = 0 ; j < Produse.getNumarTari();j++){
                    String tara = gestiune.produse.get(j).getTara();
                    writer.print(tara + " ");
                    writer.printf("%.2f %.2f %.2f", i.getTotalTaraFaraTaxe(tara) , i.getTotalTaraCuTaxe(tara) , i.getTotalTaraCuTaxeScutite(tara));
                    writer.println();
                }
                i.sortareFacturi();
                facturi = new ArrayList<Factura>();
                facturi = i.getListaFacturi();
                writer.println();
                for(Factura j : facturi){
                    writer.println(j.getNumeFactura()+System.getProperty("line.separator"));
                    writer.printf("Total %.2f %.2f",j.getTotalfaraTaxe(),j.getTotalcuTaxe());
                    writer.println(System.getProperty("line.separator"));
                    writer.println("Tara");
                    for(int k = 0 ; k < Produse.getNumarTari();k++){
                        String tara = j.getProdus(k).getTara();
                        writer.print(tara + " ");
                        writer.printf("%.2f %.2f",j.getTotalTarafaraTaxe(tara),j.getTotalTaraCuTaxe(tara));
                        writer.println();
                    }
                    writer.println();
                }
            }
        writer.close();
    }
}
