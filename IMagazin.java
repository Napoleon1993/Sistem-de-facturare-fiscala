
package Magazine;


abstract interface IMagazin{
    double getTotalFaraTaxe();
    double getTotalCuTaxe();
    double getTotalCuTaxeScutite();
    double getTotalTaraFaraTaxe(String tara);
    double getTotalTaraCuTaxeScutite(String tara);
    double getTotalTaraCuTaxe(String tara);
    double calculScutiriTaxe();
}