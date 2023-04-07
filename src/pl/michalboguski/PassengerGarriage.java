package pl.michalboguski;

public class PassengerGarriage extends Carriage implements Electric {


    public PassengerGarriage(Sender sender, Security[] securities, double netWeight, double grossWeight) {
        super(sender, securities, netWeight, grossWeight);
    }
}
