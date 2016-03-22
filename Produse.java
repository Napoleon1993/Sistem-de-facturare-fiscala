
package Produse;

public class Produse {
    protected String denumire , categorie , tara ;
    protected double pret;
    private static int numarTari;
    
    public String getDenumire(){
        return denumire;
    }
    public void setDenumire(String denumire){
        this.denumire = denumire;
    }
    
     public String getCategorie(){
        return categorie;
    }
    public void setCategorie(String categorie){
        this.categorie = categorie;
    }
     
      public String getTara(){
        return tara;
    }
    public void setTara(String tara){
        this.tara = tara;
    }
      
       public double getPret(){
        return pret;
    }
    public void setPret(double pret){
        this.pret = pret;
    }
    
    public static void setNumarTari(int n){
        numarTari = n;
    }
    
    public static int getNumarTari(){
        return numarTari;
    }
    
    @Override
    public String toString(){
        return "Denumire:"+denumire+"\nCategorie:" + categorie +"\nTara:" +tara +"\nPret:" +pret+"\n\n";
    }
}
