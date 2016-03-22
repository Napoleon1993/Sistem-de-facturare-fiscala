package Citire;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CitireTaxe {
    private Map<String,HashMap> taxeCheieCategorie = new HashMap<String , HashMap>();
    public void CitireTaxe(String nume) throws FileNotFoundException, IOException{
        RandomAccessFile fisier = new RandomAccessFile(nume,"r");
        Map<String,Double> taxeCheieTara = null;
        ArrayList<String> keyTara = new ArrayList<String>();
        int numarTari = 0;
        String linie = fisier.readLine() , cuvant;
        StringTokenizer st = new StringTokenizer(linie," \\");
        while(st.hasMoreTokens()){
            cuvant = st.nextToken();
            if(cuvant.equals("Categorie"))cuvant = st.nextToken();
            if(cuvant.equals("Tara"))cuvant = st.nextToken();
            keyTara.add(cuvant);
            numarTari++;
        }
        /*System.out.println(taxeCheieTara);
        System.out.println(numarTari);
        for(String i:keyTara)
            System.out.println(i);*/
        while((linie = fisier.readLine()) != null){
            st = new StringTokenizer(linie," ");
            while(st.hasMoreTokens()){
                cuvant = st.nextToken();
                int contor = numarTari;
                taxeCheieTara = new HashMap<>();
                while(contor > 0){
                    taxeCheieTara.put(  keyTara.get( numarTari-contor ) , Double.parseDouble( st.nextToken() ) );
                    contor--;
                }
                taxeCheieCategorie.put(cuvant, (HashMap) taxeCheieTara);
            }
        }
        fisier.close();
    }
    public Map<String,HashMap> getTaxe(){
        return taxeCheieCategorie;
    }
}
