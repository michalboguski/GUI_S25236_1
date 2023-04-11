package pl.michalboguski;

import java.util.Collections;
import java.util.LinkedList;


public class Train {
    private Lovomotive locomotive;
    private LinkedList<Carriage> carriages;
    private int maxPlugCarriages;
    private Station startStation;
    private Station destinationStation;
    private Route route;



    public Train(WorldMap map, Lovomotive locomotive, LinkedList<Carriage> carriages, int maxPlugCarriages, Station startStation, Station destinationStation) {
        this.locomotive = locomotive;
        this.carriages = carriages;
        this.maxPlugCarriages = maxPlugCarriages;
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.route = new Route(map.stations,startStation,destinationStation);
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


    @Override
    public String toString() {
        return "Train{" +
                "locomotive=" + locomotive +
                ",\n carriages=" + carriages +
                ",\n maxPlugCarriages=" + maxPlugCarriages +
                ",\n startStation=" + startStation +
                ",\n destinationStation=" + destinationStation +
                ",\n route=" + route +
                '}';
    }

    public Lovomotive getLocomotive() {
        return locomotive;
    }

    public void drive(){

        new Thread() {
            @Override
            public void run() {

                Station actualStation = null;
                Station nextStation = null;
                Station previusStation = null;
                double distance = 0;
                double movedDistance = 0;

                while (this.isAlive()) {
                    for (Link routeLink : route.getLinks()) {
                        actualStation = null;
                        nextStation = routeLink.station2;
                        previusStation = routeLink.station1;
                        distance = routeLink.distance;
                        movedDistance = 0;


                        while (movedDistance < distance) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            movedDistance += locomotive.getSpeed() / 50;
                        }
                        actualStation = nextStation;
                        System.out.print(actualStation);
                        System.out.print(" | ");
                    }
                    System.out.println();
                        Collections.reverse(route.getConnectedStations());
                    for (Link link : route.getLinks()) {
                        Station tmp = link.station2;
                        link.station2 = link.station1;
                        link.station1 = tmp;
                    }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                }
            }

        }.start();

    }
}
