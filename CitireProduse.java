
package Citire;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import Produse.Produse;
import java.util.ArrayList;


public class CitireProduse {
    private ArrayList<Produse> vectorProduse = new ArrayList<Produse>();
    public void CitireProdus(String numeFisier) throws FileNotFoundException, IOException {
        RandomAccessFile fisier = new RandomAccessFile(numeFisier,"r");
        ArrayList<String> tari = new ArrayList<String>();
        String linie , tara = null , denumire = null , categorie = null ;
        StringTokenizer st = null;
        double pret ;
        int contLinie = 1 , contorCuvinte = 1 , numarTari = 0;
        linie = fisier.readLine();
        st = new StringTokenizer(linie," ");
        while( st.hasMoreTokens() ){
            tara = st.nextToken();
            if( tara.equals("Produs") )tara = st.nextToken();
            if( tara.equals("Categorie") ) tara = st.nextToken();
            tari.add(tara);
            numarTari++;
        }
        while( (linie = fisier.readLine()) != null ){
            st = new StringTokenizer(linie," ");
            while( st.hasMoreTokens() ){
                denumire = st.nextToken();
                categorie = st.nextToken();
                contorCuvinte = numarTari;
                while(contorCuvinte > 0){
                    Produse produs = new Produse();
                    produs.setTara(tari.get(numarTari-contorCuvinte));
                    produs.setDenumire(denumire);
                    produs.setCategorie(categorie);
                    pret = Double.parseDouble(st.nextToken());
                    produs.setPret(pret);
                    vectorProduse.add(produs);
                    contorCuvinte --;
                }
            }
        }
        Produse.setNumarTari(numarTari);
        fisier.close();
    }
    public ArrayList<Produse> getVectorProduse (){
        return vectorProduse;
    }
}
