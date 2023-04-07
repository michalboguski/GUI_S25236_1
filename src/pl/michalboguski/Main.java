package pl.michalboguski;

public class Main {

    public static void main(String[] args) {
	Map map = new Map(40,30);
    Log.info("utworzono mape swiata");

    map.createStationsInRandomPosition(" # "," . ",Station.createRandomStations(100));

        map.showMap();
    }
}
