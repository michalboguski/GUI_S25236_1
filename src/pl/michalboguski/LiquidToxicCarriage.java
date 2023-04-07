package pl.michalboguski;

public class LiquidToxicCarriage extends HavyCarriage implements Liquid{

    public LiquidToxicCarriage(Sender sender, Security[] securities, double netWeight, double grossWeight) {
        super(sender, securities, netWeight, grossWeight);
    }
}
