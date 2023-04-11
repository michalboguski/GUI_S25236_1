package pl.michalboguski;

//          Dodatkowo lokomotywy posiadają przypisaną prędkość, z którą się porusza, a która co 1
//        sekundę prędkość będzie się zmniejszała lub zwiększała (losowo) o 3%. Na podstawie tej prędkości
//        należy uzależnić ruch składów pociągów po trasach.


import java.util.HashSet;
import java.util.Set;

public class Lovomotive {
    private String name;
    private Station homeStation;
    private Station sourceStation;
    private Station destinationStation;
    private double speed;
    private Clock clock;
    private Set<Electric> electricConnections;
    private int maxPull;
    private int id;

    public static int freeID = 0;

    public Lovomotive(String name, Station homeStation, Station sourceStation, Station destinationStation, double speed, int maxPull) {
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.speed = speed;
        this.maxPull = maxPull;
        this.id = ++freeID;
        electricConnections = new HashSet<Electric>();
        this.clock = new Clock(this,1000);
        clock.start();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station getHomeStation() {
        return homeStation;
    }

    public void setHomeStation(Station homeStation) {
        this.homeStation = homeStation;
    }

    public Station getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(Station sourceStation) {
        this.sourceStation = sourceStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public Set<Electric> getElectricConnections() {
        return electricConnections;
    }

    public void setElectricConnections(Set<Electric> electricConnections) {
        this.electricConnections = electricConnections;
    }

    public int getMaxPull() {
        return maxPull;
    }

    public void setMaxPull(int maxPull) {
        this.maxPull = maxPull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getFreeID() {
        return freeID;
    }

    public static void setFreeID(int freeID) {
        Lovomotive.freeID = freeID;
    }
}
