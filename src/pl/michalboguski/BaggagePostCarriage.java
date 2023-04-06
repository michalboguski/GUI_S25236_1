package pl.michalboguski;

public class BaggagePostCarriage extends Carriage implements Post{
    public BaggagePostCarriage(Sender sender, Security[] securities, double netWeight) {
        super(sender, securities, netWeight);
    }
}
