package pl.michalboguski;

import java.util.List;

public class Train {
    private Lovomotive locomotive;
    private List<Carriage> carriages;

    public Train(Lovomotive locomotive, List<Carriage> carriages) {
        this.locomotive = locomotive;
        this.carriages = carriages;
    }

    public void addCarriage(Carriage carriage){
        this.carriages.add(carriage);
    }
}
