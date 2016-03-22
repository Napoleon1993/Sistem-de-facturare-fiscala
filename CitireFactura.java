
package Citire;

import Factory.Factory;
import Facturi.Factura;
import Magazine.*;
import Produse.Produse;
import Produse.ProduseComandate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class CitireFactura {
    private ArrayList<Magazin> vectorMagazine = new ArrayList<Magazin>();
    public void CitireFactura(String numeFisier) throws FileNotFoundException, IOException{
        RandomAccessFile fisier = new RandomAccessFile(numeFisier,"r");
        StringTokenizer st = null;
        String tip = null , nume = null, linie , cuvant = null;
        
        ArrayList<String> tipMagazin = new ArrayList<String>();
        ArrayList<String> numeMagazin = new ArrayList<String>();
        ArrayList<Integer> numarComenzi = new ArrayList<Integer>();
        ArrayList<ProduseComandate> vectorProduseComandate = new ArrayList<ProduseComandate>();
        ArrayList<String> vectorNumeFacturi = new ArrayList<String>();
        ArrayList<Integer> numarFacturi = new ArrayList<Integer>();
        
        ProduseComandate produs = null;
        int contorMagazin = -1 , contorFacturi = -1 , contorProduse = -1 , indiceProduse = -1;
        while( (linie = fisier.readLine()) != null ){
            st = new StringTokenizer(linie," :");
            while(st.hasMoreTokens()){
                cuvant = st.nextToken();
                if(cuvant.equals("Magazin")){
                    contorMagazin++;
                    contorFacturi = -1;
                    numarFacturi.add(contorFacturi);
                    tip = st.nextToken();
                    nume = st.nextToken();
                    tipMagazin.add(tip);
                    numeMagazin.add(nume);
                    //System.out.println(tipMagazin +" "+numeMagazin);
                }
                if(cuvant.startsWith("Factura")){
                    contorProduse = 0;
                    contorFacturi++;
                    indiceProduse++;
                    numarFacturi.add(contorMagazin, contorFacturi);
                    vectorNumeFacturi.add(indiceProduse,cuvant);
                    numarComenzi.add(indiceProduse,0);
                }
                if(cuvant.equals("Cantitate") == false && cuvant.equals("Tara") == false && cuvant.equals("DenumireProdus") == false && cuvant.equals("Magazin") == false && cuvant.startsWith("Factura") == false){
                    contorProduse++;
                    produs = new ProduseComandate();
                    produs.setDenumire(cuvant);
                    cuvant = st.nextToken();
                    produs.setTara(cuvant);
                    produs.setCantitate(Double.parseDouble(st.nextToken()));
                    vectorProduseComandate.add(produs);
                    numarComenzi.set(indiceProduse,contorProduse);
                }
            }
        }
        int l = 0 , inceput = 0 , sfarsit = 0 ;
        for(int i = 0 ; i <= contorMagazin ; i++){
            Magazin magazin = Factory.createMagazin(tipMagazin.get(i));
            magazin.setNume(numeMagazin.get(i));
            magazin.setNumarFacturi((numarFacturi.get(i)+1));
            for(int j = 0 ; j <= numarFacturi.get(i); j++){
                Factura factura = new Factura();
                factura.setNumarProduse(numarComenzi.get(l));
                factura.setNumeFactura(vectorNumeFacturi.get(l));
                sfarsit += numarComenzi.get(l);
                for(int k = inceput ; k < sfarsit ; k++)
                    factura.setProdusComandat(vectorProduseComandate.get(k));
                l++;
                inceput = sfarsit;
                magazin.setFactura(factura);
            }
            vectorMagazine.add(magazin);
        }
        fisier.close();
    }
    public ArrayList<Magazin> getVectorMagazine(){
        return vectorMagazine;
    }
}
