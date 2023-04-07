package pl.michalboguski;

public class PostCarriage extends Carriage implements Post{

    public PostCarriage(Sender sender, Security[] securities, double netWeight, double grossWeight) {
        super(sender, securities, netWeight, grossWeight);
    }
}
