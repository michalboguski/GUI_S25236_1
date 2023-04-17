package pl.michalboguski;

import java.util.*;

public class Station{

    private String name;
    Coorrdinates position;

    private HashMap<Station, Boolean> linkedStation;
    private HashMap<Station,LinkedList<Train>> queues;

    public Station(String name, Coorrdinates position) {
        this.name = name;
        this.position = position;
        this.linkedStation = new HashMap<>();
        this.queues = new HashMap<>();


    }

    public Station(String name) {
        this.name = name;
    }
    public Station(String name, int x, int y, WorldMap map) {
        this.name = name;
        Coorrdinates tmp = new Coorrdinates(x, y);
        if (!map.stationsPositions.contains(tmp))
        this.position = tmp;
    }

    public void manage(){
        StationManager stationManager = new StationManager(this);
        this.linkedStation.forEach((n, k) -> this.queues.put(n, new LinkedList<>()));
        stationManager.start();
    }

    public double calculateDistance(Station s2) {
        double x1 = getPosition().getX();
        double y1 = getPosition().getY();
        double x2 = s2.getPosition().getX();
        double y2 = s2.getPosition().getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coorrdinates getPosition() {
        return position;
    }

    public void setPosition(Coorrdinates position) {
        this.position = position;
    }

    public HashMap<Station, Boolean> getLinkedStation() {
        return linkedStation;
    }

    public HashMap<Station, LinkedList<Train>> getQueues() {
        return queues;
    }

    public void setQueues(HashMap<Station, LinkedList<Train>> queues) {
        this.queues = queues;
    }

    public void setLinkedStation(HashMap<Station, Boolean> linkedStation) {
        this.linkedStation = linkedStation;
    }

    @Override
    public String toString() {
        return "" +name;// + "["+position.getX()+", "+position.getY()+"]";
    }
}
