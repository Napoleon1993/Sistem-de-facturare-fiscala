
package Produse;


public class ProduseComandate extends Produse {
    private double cantitate , taxa;
    
    public void setTaxa(double taxa){
        this.taxa = taxa;
    }
    public double getTaxa(){
        return taxa;
    }
    public void setCantitate(double cantitate){
        this.cantitate = cantitate;
    }
    public double getCantitate(){
        return cantitate;
    }
    public boolean verificareTaxa(){
        if (taxa == 0)return false;
            return true;
    }
    public boolean verificarePret(){
        if(pret == 0)return false;
            return true;
    }
    
    public String toString(){
        return "\t\tDenumirea produsului= " + denumire + "\n\t\tTara= " + tara + "\n\t\tCantitatea= "+ cantitate + "\n\t\tpret :"+ pret +"\n\t\tCategorie="+ categorie +"\n\t\t taxa=" + taxa+"\n\n";
    }
}
