package pl.michalboguski;

//        Istnieją różnego typu wagony kolejowe. Każdy z typów wagonów posiada inny zestaw cech
//        (np. nadawca, zabezpieczenia, waga netto, waga brutto, liczba miejsc siedzących itp.). W przypadku każdego typu wagonu należy dodać ponad wymienione co najmniej dwie unikalne cechy do
//        każdego typu wagonu. Każdy wagon posiada swój unikatowy numer identyfikacyjny nadawany
//        automatycznie podczas tworzenia obiektu.

public abstract class Carriage {

    Sender sender;
    Security[] securities;
    double netWeight;

    public Carriage(Sender sender, Security[] securities, double netWeight) {
        this.sender = sender;
        this.securities = securities;
        this.netWeight = netWeight;
    }
}
