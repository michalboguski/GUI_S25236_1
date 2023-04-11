package pl.michalboguski;

import java.util.*;

public class Station {
    private String name;
    Coorrdinates position;
    private Set<Station> linkedStation;

    public Station(String name, Coorrdinates position) {
        this.name = name;
        this.position = position;
        this.linkedStation = new HashSet<>();
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

    public Set<Station> getLinkedStation() {
        return linkedStation;
    }

    public void setLinkedStation(Set<Station> linkedStation) {
        this.linkedStation = linkedStation;
    }

    @Override
    public String toString() {
        return "" +name;// + "["+position.getX()+", "+position.getY()+"]";
    }
}
