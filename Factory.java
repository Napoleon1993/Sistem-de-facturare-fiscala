
package Factory;
import Magazine.*;


public class Factory {
    Factory instance = new Factory();
    private Factory(){}
    public enum MagazinType{
        HyperMarket,
        MiniMarket,
        MediumMarket
    }
    public static Magazin createMagazin(String tip){
        switch(tip){
            case "HyperMarket": return new HyperMarket();
            case "MiniMarket": return new MiniMarket();
            case "MediumMarket": return new MediumMarket();
        }
        throw new IllegalArgumentException("Tipul magazinului introdus " + tip + " nu este recunoscut.");
    }
        
}
