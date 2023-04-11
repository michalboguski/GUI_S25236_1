package pl.michalboguski;

import java.util.*;

public class Route {
    private LinkedList<Link> connectedStations;
    Station startStation;
    Station endStation;


    public Route(Set<Station> all, Station startStation, Station endStation) {
        this.connectedStations = new LinkedList<>(serchRoute(all,startStation,endStation));
        this.startStation = startStation;
        this.endStation = endStation;

    }

    public LinkedList<Link> serchRoute(Set<Station> allStations, Station sourceStation, Station destinationStation){
        Map<Station, Station> visided = new LinkedHashMap<>(); // STATION, PARENT
        LinkedList<Station> queue = new LinkedList<>();
        LinkedList<Link> links = new LinkedList<>();
        boolean found = false;
        Station source = sourceStation;
        Station destination = destinationStation;
        queue.add(source);
        visided.put(source,null);

        Iterator<Station> stationIterator;
        while (queue.size() != 0 && !found ){
            source = queue.poll();

            stationIterator = source.getLinkedStation().iterator();
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

        links = links(visided,sourceStation,destinationStation);
        return  links;
    }
    public LinkedList<Link> links(Map<Station, Station> BFSRoutes,Station s, Station d){
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
            s+= link.station1+"--"+link.station2+" | ";
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
