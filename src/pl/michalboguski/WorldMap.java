package pl.michalboguski;

import java.util.*;

public class WorldMap {
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
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
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
        for (Station station : stations) {
            worldMap[station.position.getY()][station.position.getX()] = station.getName();
        }
    }

    public void showMap() {

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                System.out.print(worldMap[i][j]);
            }
            System.out.println();
        }
    }

    public void establishConnections(){
        Station[] arrS = stations.toArray(new Station[0]);


        for (int i = 0; i < arrS.length; i++) {
            List<Link> tmp = new ArrayList<>();
            for (int j = 0; j < arrS.length; j++) {
                if (i!=j)
//                    System.out.print("STATION:"+arrS[i].getName()+" |");
//                System.out.print(arrS[i].calculateDistance(arrS[j])+" |");
//                    System.out.print("STATION:"+arrS[j].getName());
//                    System.out.println();
                tmp.add(new Link(arrS[i],arrS[j]));
            }

            Collections.sort(tmp, new Comparator<Link>() {
                @Override
                public int compare(Link o1, Link o2) {
                    return Double.compare(o1.distance,o2.distance);
                }
            });
            for (int k = 0; k< Math.sqrt(tmp.size()-1); k++){
                arrS[i].getLinkedStation().add(tmp.get(k).station2);
            }

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
}
