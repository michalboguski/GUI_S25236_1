package pl.michalboguski;

//        Istnieją różnego typu wagony kolejowe. Każdy z typów wagonów posiada inny zestaw cech
//        (np. nadawca, zabezpieczenia, waga netto, waga brutto, liczba miejsc siedzących itp.). W przypadku każdego typu wagonu należy dodać ponad wymienione co najmniej dwie unikalne cechy do
//        każdego typu wagonu. Każdy wagon posiada swój unikatowy numer identyfikacyjny nadawany
//        automatycznie podczas tworzenia obiektu.

public abstract class Carriage {

    protected Sender sender;
    protected Security[] securities;
    protected double netWeight;
    protected double grossWeight;

    public Carriage(Sender sender, Security[] securities, double netWeight, double grossWeight) {
        this.sender = sender;
        this.securities = securities;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Security[] getSecurities() {
        return securities;
    }

    public void setSecurities(Security[] securities) {
        this.securities = securities;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }
}
