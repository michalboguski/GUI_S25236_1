package pl.michalboguski;

public class LiquidCarriage extends StandardCarriage implements Liquid{
    public LiquidCarriage(Sender sender, Security[] securities, double netWeight) {
        super(sender, securities, netWeight);
    }
}
