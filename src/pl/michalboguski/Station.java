package pl.michalboguski;

public class Station {
    private String name;
    Coorrdinates position;
    private Station[] linkedStation;

    public Station(String name, Coorrdinates position) {
        this.name = name;
        this.position = position;
    }

    public Station(String name) {
        this.name = name;
    }

    public static Station[] createRandomStations(int number){
        Station[] stations = new Station[number];

        for (int i = 0; i< number; i++){
            stations[i] = new Station("Stacja 00"+i);
        }
        return stations;
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

    public Station[] getLinkedStation() {
        return linkedStation;
    }

    public void setLinkedStation(Station[] linkedStation) {
        this.linkedStation = linkedStation;
    }
}
