package pl.michalboguski;

public class LiquidToxicCarriage extends HavyCarriage implements Liquid{
    public LiquidToxicCarriage(Sender sender, Security[] securities, double netWeight) {
        super(sender, securities, netWeight);
    }
}
