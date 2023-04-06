package pl.michalboguski;

public class RestaurantCarriage extends Carriage implements Electric{
    public RestaurantCarriage(Sender sender, Security[] securities, double netWeight) {
        super(sender, securities, netWeight);
    }
}
