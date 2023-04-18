package pl.michalboguski;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Train extends Thread{
    public static int freeId = 0;
    private String name;
    private Lovomotive locomotive;
    private LinkedList<Carriage> carriages;
    private int maxPlugCarriages;
    private Station startStation;
    private Station destinationStation;
    private Route route;
    private Set<Station> allStation;




    public Train(Lovomotive locomotive, LinkedList<Carriage> carriages, int maxPlugCarriages, WorldMap map, Station startStation, Station destinationStation) {
        this.name = "Train"+ ++freeId;
        this.locomotive = locomotive;
        this.carriages = carriages;
        this.maxPlugCarriages = maxPlugCarriages;
        this.allStation = map.getStations();
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.route = new Route(startStation, destinationStation);
    }

    public double calculateCarriagesWeight(){
        double totalWeight = 0;
        for (Carriage carriage : carriages) {
            totalWeight += carriage.getGrossWeight();
        }
        return totalWeight;
    }

//    public static Train randomTrain(WorldMap map){
//        return new Train();
//    }

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

    public void run(){
                Station actualStation = null;
                Station nextStation = null;
                Station previusStation = null;
                double distance = 0;
                double movedDistance = 0;
        Log.info(this.name+ "1 przed while");
                while (this.isAlive()) {
                    Log.info(this.name+ "2 w while przed forech");
                    for (Link routeLink : route.getLinks()) {
                        Log.info(this.name+ "3 w  forech");
                        nextStation = routeLink.station2;
                        previusStation = routeLink.station1;
                        actualStation = previusStation;
                        distance = routeLink.distance;
                        movedDistance = 0;
                        int counter =  0;
                        int countWaiting =0;
                        LinkedList<Train>  qtrain = new LinkedList<>();
                                qtrain = previusStation.getQueues().get(nextStation);

                        qtrain.add(this);
                        System.out.println(this.name+ "czekam w kolejce na stacji");
                        while (!qtrain.peekFirst().equals(this) || nextStation.getLinkedStation().get(previusStation)) {

                        }
                        qtrain.pollFirst();
                            System.out.println(this.name+": ruszam");

                            previusStation.getLinkedStation().replace(nextStation, true);
                            nextStation.getLinkedStation().replace(previusStation, true);
                            while (movedDistance < distance) {
                                counter++;

                                waitFor(this, 60);
                                if (locomotive.getSpeed() > 200) try {
                                    throw new RailroadHazard(this + "Pedziza szybko");
                                } catch (RailroadHazard e) {
                                    e.printStackTrace();
                                }
                                movedDistance += locomotive.getSpeed() / 3600;
                                if (counter % 10 == 0) {
                                    System.out.println(this.name+" przejechano: " + String.format("%,.2f", movedDistance) + " z " + String.format("%,.2f", distance) + " " + (int) (100 * movedDistance / distance) + "%  ze stacji: " +
                                            previusStation + " do: " + nextStation);

                                }
                            }



                        previusStation.getLinkedStation().replace(nextStation,false);
                        nextStation.getLinkedStation().replace(previusStation,false);

                        actualStation = nextStation;

                        if (actualStation.equals(destinationStation) || actualStation.equals(startStation)) {
                            break;
                        }
                        System.out.println(this.name+" dojechalem do stacji: "+actualStation);
                        System.out.print(this.name+" czekam 2 sekundy czli realnie 33 minuty");
                        waitFor(this,2000);
                    }
                    System.out.println(this.name+" dojechalem do konca na stacje: "+ actualStation);
                        Collections.reverse(route.getConnectedStations());
                    System.out.println(this.name+" odwracanie trasy");
                    for (Link link : route.getLinks()) {
                        Station tmp = link.station2;
                        link.station2 = link.station1;
                        link.station1 = tmp;
                    }

                    System.out.println(this.name+" czekam 30 sekund cczyli 8h20m realnie");
                            waitFor(this,5000);
                }
    }



    public void waitFor(Thread t, int milis){
        try {
            this.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Route getRoute() {
        return route;
    }
}
