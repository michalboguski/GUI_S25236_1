package pl.michalboguski;

import java.util.*;

public class Program {
    public static final int second = 1;
    public static final int minute = 60;
    public static final int hour = 3600;
    private WorldMap worldMap;
    static int mapWidth;
    static int mapHeight;
    public Program() {

    }
    public  Set<Station> getStations(){
        return worldMap.getStations();
    }

    public void establishConnectionsForAll(int min){

        Station[] arrS = this.getStations().toArray(new Station[0]);


        for (int i = 0; i < arrS.length; i++) {
            List<Link> tmp = new ArrayList<>();
            for (int j = 0; j < arrS.length; j++) {
                if (i!=j){
                    tmp.add(new Link(arrS[i],arrS[j]));
                }
            }

            tmp.sort(new Comparator<Link>() {
                @Override
                public int compare(Link o1, Link o2) {
                    return Double.compare(o1.distance, o2.distance);
                }
            });
            if (min == 0) {min = (int) (Math.sqrt(tmp.size()+1));}
            for (int k = 0; k< min; k++){
                if (!arrS[i].equals(tmp.get(k).station2)) {
                    arrS[i].getLinkedStation().put(tmp.get(k).station2, false);
                    tmp.get(k).station2.getLinkedStation().put(arrS[i], false);
                }
            }
        }
    }

    public void establishConnection(Station station,int min){
        List<Link> tmp = new ArrayList<>();
            for (Station s : getStations()) {
                if (!s.equals(station)){
                    tmp.add(new Link(station,s));
                }
            }
            tmp.sort(new Comparator<Link>() {
                @Override
                public int compare(Link o1, Link o2) {
                    return Double.compare(o1.distance, o2.distance);
                }
            });
            if (min == 0) {min = (int) (Math.sqrt(tmp.size()));}
            for (int k = 0; k< min; k++){
                connectStations(tmp.get(k).station2,station);
            }

    }

    public void connectStations(Station station1, Station station2){
        if (!station1.equals(station2)) {
            station1.getLinkedStation().put(station2, false);
            station2.getLinkedStation().put(station1, false);
            System.out.println("conected: "+station1+" and "+station2+" succes");
        }
        System.out.println("stations ara the same. Cannot coneted with self");
    }

    public void uptadeStationPositions(Station station){
            worldMap.graphicViev[station.position.getY()][station.position.getX()] = station.getName();
    }
    public void createRandomStations(int number){
        int stationCount = 0;
        while (stationCount < number){
            getStations().add(this.createStation());
                stationCount++;

        }
    }



    public void getNumberOfLinkedStations(){
        for (Station station : this.getStations()) {
            System.out.print(station.getLinkedStation().size()+" |");
        }
    }
    private Station createStation() {
        Station newStation = new Station();
        getStations().add(newStation);
        uptadeStationPositions(newStation);
        return newStation;
    }

//    public Lovomotive createLocomotive(){
//        return  new Lovomotive()
//    }




    public static void main(String[] args) {
new Menu();
        Program program = new Program();
        program.test();
    }
    public void test(){
        worldMap = new WorldMap(40,30, " . ");
        createRandomStations(100);
        System.out.println("Liczba stacji: " +getStations().size());

        worldMap.showMap();
        establishConnectionsForAll(0);

        System.out.println("liczba stacji: "+getStations().size());
        System.out.println(getStations());

        for (Station station : getStations()) {
            System.out.println(station.getName()+": "+station.getLinkedStation().size());
            station.printLinkedStations();
            System.out.println();
        }



        Lovomotive l1 = new Lovomotive("Lokomtywa1",null,null,null,100,10);
        Carriage c1 = new HavyCarriage(new Sender("ADAM"),new Security[]{Security.HEAVY_DOOR},10000,20000);
        Carriage c2 = new HavyCarriage(new Sender("EWA"),new Security[]{Security.HEAVY_DOOR},10000,22000);
        Carriage c3 = new HavyCarriage(new Sender("DAMIAN"),new Security[]{Security.HEAVY_DOOR},10000,21000);

        LinkedList<Carriage> carriages = new LinkedList<>(Arrays.asList(c1,c2,c3));



}
}
