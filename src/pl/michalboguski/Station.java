package pl.michalboguski;

import java.util.*;

public class Station{
    public static int idLoop = 0;
    public static int freeID = 0;
    public static char freeNick = 'A';
    public static Set<Coorrdinates> stationsPositions = new HashSet<>();

    private int id;
    private String name;
    Coorrdinates position;

    private HashMap<Station, Boolean> linkedStation;
    private HashMap<Station,LinkedList<Train>> queues;

    public Station() {
        this.id = ++freeID;
        if (freeID % 99 == 0) {freeNick++; idLoop = 0;}

        if (idLoop < 10) {
            this.name = freeNick+"0"+ ++idLoop;
        } else {
            this.name = String.valueOf(freeNick)+""+ ++idLoop;
        }

        Random n = new Random();
        Coorrdinates positionTmp = new Coorrdinates(n.nextInt(Program.mapWidth),n.nextInt(Program.mapHeight));
        while (stationsPositions.contains(positionTmp)) {
            positionTmp = new Coorrdinates(n.nextInt(Program.mapWidth),n.nextInt(Program.mapHeight));
        }
        this.position = positionTmp;
        stationsPositions.add(positionTmp);
        this.linkedStation = new HashMap<>();
        this.queues = new HashMap<>();


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
        return this.linkedStation;
    }

    public HashMap<Station, LinkedList<Train>> getQueues() {
        return queues;
    }

    @Override
    public String toString() {
        return "" +name;// + "["+position.getX()+", "+position.getY()+"]";
    }

    public int getId() {
        return id;
    }

    public void printLinkedStations(){
        for (Station station : linkedStation.keySet()){
            System.out.print(station.toString()+", ");
        }
    }
}
