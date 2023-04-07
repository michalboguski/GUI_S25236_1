package pl.michalboguski;

import java.util.List;

public class Train {
    private Lovomotive locomotive;
    private List<Carriage> carriages;
    private int maxPlugCarriages;

    public Train(Lovomotive locomotive, List<Carriage> carriages, int maxPlugCarriages) {
        this.locomotive = locomotive;
        this.carriages = carriages;
        this.maxPlugCarriages = maxPlugCarriages;
    }

    public double calculateCarriagesWeight(){
        double totalWeight = 0;
        for (Carriage carriage : carriages) {
            totalWeight += carriage.getGrossWeight();
        }
        return totalWeight;
    }

    public void addCarriage(Carriage carriage) throws Exception {
        if ((locomotive.getMaxPull() >= this.calculateCarriagesWeight()) && (maxPlugCarriages <= carriages.size()))
        this.carriages.add(carriage);
        else
            throw new Exception("CANT ADD CARRIAGE: TO MANY OR OVERWEIGHT!!! ");
    }
}
