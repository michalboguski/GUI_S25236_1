package pl.michalboguski;

import java.util.*;

public class WorldMap {
    public static final int second = 1;
    public static final int minute = 60;
    public static final int hour = 3600;

    private int width;
    private int height;
    String[][] worldMap;
    Set<Station> stations;
    Set<Coorrdinates> stationsPositions;
    Set<Link> links;

    public WorldMap(int width, int height, String emptyPosition) {
        this.width = width;
        this.height = height;
        this.worldMap = new String[height][width];
        this.stations = new HashSet<>();
        this.stationsPositions = new HashSet<>();
        fillMap(emptyPosition);

    }

    public void fillMap(String c) {
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                worldMap[i][j] = c;
            }
        }
    }

    public void createRandomStations(int number, String nameStart){
        Random n = new Random();
        int stationCount = 0;

        while (stationCount < number){
            Coorrdinates position = new Coorrdinates(n.nextInt(getWidth()),n.nextInt(getHeight()));
            if (!stationsPositions.contains(position)) {
                Station stationTmp = new Station(nameStart+(stationCount+1),position);
                stationsPositions.add(position);
                stations.add(stationTmp);
                stationCount++;
            }

        }
        uptadeStationPositions();

    }

    public void uptadeStationPositions(){
        for (Station station : stations) {
            worldMap[station.position.getY()][station.position.getX()] = station.getName();
        }
    }

    public void showMap() {

        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.print(worldMap[i][j]);
            }
            System.out.println();
        }
    }


    public void establishConnections(int minLinks){
        int min = 0;
        Station[] arrS = stations.toArray(new Station[0]);


        for (int i = 0; i < arrS.length; i++) {
            List<Link> tmp = new ArrayList<>();
            for (int j = 0; j < arrS.length; j++) {
                if (i!=j){
                tmp.add(new Link(arrS[i],arrS[j]));
            }
            }

            Collections.sort(tmp, new Comparator<Link>() {
                @Override
                public int compare(Link o1, Link o2) {
                    return Double.compare(o1.distance,o2.distance);
                }
            });
            if (min == 0) {min = (int) (Math.sqrt(tmp.size()));}
            for (int k = 0; k< min; k++){
                arrS[i].getLinkedStation().put(tmp.get(k).station2,false);
                tmp.get(k).station2.getLinkedStation().put(arrS[i],false);
            }
    }
        for (Station station : stations) {
            station.manage();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[][] getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(String[][] worldMap) {
        this.worldMap = worldMap;
    }

   public List<Station> stationsToList(){
       List<Station> l = new ArrayList<>(stations);
        return l;
   }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    public Set<Coorrdinates> getStationsPositions() {
        return stationsPositions;
    }

    public void setStationsPositions(Set<Coorrdinates> stationsPositions) {
        this.stationsPositions = stationsPositions;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public void getNumberOfLinkedStations(){
        for (Station station : stations) {
            System.out.print(station.getLinkedStation().size()+" |");
        }
    }
}
