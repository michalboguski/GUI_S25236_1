package pl.michalboguski;

public class PassengerGarriage extends Carriage implements Electric {
    public PassengerGarriage(Sender sender, Security[] securities, double netWeight) {
        super(sender, securities, netWeight);
    }


}
