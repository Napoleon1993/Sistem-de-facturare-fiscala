Nastase Cosmin 325 CC
Dificultate:Dificila
Ore alocate : 20
Mod de implementare:
	Am citit din fisierul produse fiecare produs intr-o lista de produse .
	Am citit din fisierul de taxe , taxele pentru fiecare categorie de produs si am retinut intr-un hashmap cu cheia reprezentand categoria care are ca valoare un alt hashmap.Cel de-al 2 lea hashmap are ca si cheie tara si ca valoare taxa respectiva.
	Din fisierul de facturi citesc cate un magazin il instantiez cu factory apoi creez o lista de facturi iar in fiecare factura retin produsele comandate.
	In main cu ajutorul dictionarului de taxe introduc taxele in campul de taxe al produselor.
	Am instantiat Gestiunea cu metoda getGestiuniInstanta(ArrayList<Magazin> m , ArrayList<Produse> p , Map<String , HashMap> t).
	Apoi le afisez la fel cum trebuiesc afisate.