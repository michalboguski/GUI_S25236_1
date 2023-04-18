package pl.michalboguski;

import java.util.*;

public class Route {
    private LinkedList<Link> connectedStations;
    Station startStation;
    Station endStation;


    public Route( Station startStation, Station endStation) {
        System.out.println("konstruktor ROUTE");
        this.connectedStations = new LinkedList<>(serchRoute(startStation,endStation));
        this.startStation = startStation;
        this.endStation = endStation;

    }



    public LinkedList<Link> serchRoute( Station sourceStation, Station destinationStation){
        Map<Station, Station> visided = new LinkedHashMap<>(); // STATION, PARENT
        LinkedList<Station> queue = new LinkedList<>();
        LinkedList<Link> links = new LinkedList<>();
        boolean found = false;
        Station source = sourceStation;
        System.out.println("source.getLinkedStation() :" +source.getLinkedStation());
        Station destination = destinationStation;
        queue.add(source);
        System.out.println("source.getLinkedStation() :" +source.getLinkedStation());
        visided.put(source,null);
        System.out.println("source.getLinkedStation() :" +source.getLinkedStation());
        Iterator<Station> stationIterator;
        while (queue.size() != 0 && !found ){
            source = queue.poll();
            System.out.println("source.getLinkedStation() :" +source.getLinkedStation());

            stationIterator = source.getLinkedStation().keySet().iterator();
            System.out.println("source.getLinkedStation() :" +source.getLinkedStation());
            System.out.println("source ma next station " + stationIterator.hasNext());
            while (stationIterator.hasNext()) {
                Station tmpStation = stationIterator.next();
                if (!visided.containsKey(tmpStation)) {
                    visided.put(tmpStation, source);
                    queue.add(tmpStation);
                }
                if (tmpStation.equals(destination)) {
                    links.add(new Link(source, tmpStation));
                    found = true;
                    break;
                }
            }
        }
        System.out.println("koniec searchroute, visited: " + visided);
        links = links(visided,sourceStation,destinationStation);

        return  links;
    }
    public LinkedList<Link> links(Map<Station, Station> BFSRoutes, Station s, Station d){
        LinkedList<Link> LINKS = new LinkedList<>();
        Station station = d;
        Station parent ;

        while ((parent = BFSRoutes.get(station)) != null ){
            Link newLink = new Link(parent,station);
            if (!LINKS.contains(newLink)) {
                LINKS.add(newLink);
            }
            if (parent.equals(s)) {
                break;
            }
            station = parent;

        }

        Collections.reverse(LINKS);
        return LINKS;
    }



    @Override
    public String toString() {
        return "POŁĄCZENIE Z "+ startStation.toString()+ " DO " + endStation+ " : " +
                printConections();
    }

    public LinkedList<Link> getLinks() {
        return connectedStations;
    }

    public void setLinks(LinkedList<Link> links) {
        this.connectedStations = links;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }



    public String printConections(){
        String s ="";
        for (Link link : connectedStations) {
            s+= link.station1+"<-->"+link.station2+"("+(int)link.distance+") |  ";
        }
        return s +" liczba linkow: "+connectedStations.size();
    }

    public LinkedList<Link> getConnectedStations() {
        return connectedStations;
    }

    public void setConnectedStations(LinkedList<Link> connectedStations) {
        this.connectedStations = connectedStations;
    }
}
