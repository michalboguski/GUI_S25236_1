package pl.michalboguski;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	WorldMap map = new WorldMap(40,30, " . ");
    Log.info("utworzono mape swiata");
    map.createRandomStations(10,"A");
        map.showMap();
        map.establishConnections();
        for (Station station : map.stations) {
            System.out.println(station+": "+station.getLinkedStation());
        }

        for (Station s1 : map.stations) {
            for (Station s2: s1.getLinkedStation()) {
                System.out.print("station: "+s2+" dystans: "+s1.calculateDistance(s2)+" | ");
            }
            System.out.println();
        }

    }
}
