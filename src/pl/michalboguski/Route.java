package pl.michalboguski;

import java.util.*;

public class Route {
    private List<Link> links;
    Station startStation;
    Station endStation;

    public Route(Set<Station> all, Station startStation, Station endStation) {
        this.links = serchRoute(all,startStation,endStation);
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public LinkedList<Link> serchRoute(Set<Station> allStations, Station s, Station d){
        Map<Station, Boolean> visided = new HashMap<>();
        LinkedList<Station> queue = new LinkedList<>();
        LinkedList<Link> links = new LinkedList<>();
        boolean found = false;
        visided.put(s,true);
        queue.add(s);

        Iterator<Station> stationIterator;
        while (queue.size() != 0 && !found ){
            Station tmp = s;
            s = queue.poll();
           // links.add(new Link(tmp,s));

            stationIterator = s.getLinkedStation().listIterator();
            while (stationIterator.hasNext()) {
                Station tmpStation = stationIterator.next();
                if (!visided.containsKey(tmpStation)) {
                    visided.put(tmpStation,true);
                    queue.add(tmpStation);
                }
                if (tmpStation.equals(d)) {
                    links.add(new Link(s, tmpStation));
                    found = true;
                    break;
                }
            }
        }
        return  links;
    }

    @Override
    public String toString() {
        return "POŁĄCZENIE Z "+ startStation.toString()+ " DO " + endStation+ " przez: " +
                printConections();
    }

    public String printConections(){
        String s ="";
        for (Link link : links) {
            s+= link.station2+", ";
        }
        return s;
    }
}
