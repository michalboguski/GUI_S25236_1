package pl.michalboguski;

public class CoolingCarriage extends StandardCarriage implements Electric{

    public CoolingCarriage(Sender sender, Security[] securities, double netWeight, double grossWeight) {
        super(sender, securities, netWeight, grossWeight);
    }
}
