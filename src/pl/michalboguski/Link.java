package pl.michalboguski;

public class Link {
    Station station1;
    Station station2;

    double distance = 0;

    public Link(Station station1, Station station2) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = calculateDistance(station1,station2);
    }

    public double calculateDistance(Station s1, Station s2) {
        double x1 = s1.getPosition().getX();
        double y1 = s1.getPosition().getY();
        double x2 = s2.getPosition().getX();
        double y2 = s2.getPosition().getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
