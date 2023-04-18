package pl.michalboguski;

import java.util.*;

public class WorldMap {


    private int width;
    private int height;
    String[][] graphicViev;

    private Set<Station> stations;



    public WorldMap(int width, int height, String emptyPosition) {
        this.width = Program.mapWidth = width;
        this.height = Program.mapHeight = height;
        this.graphicViev = new String[height][width];
        this.stations = new HashSet<>();
        fillMap(emptyPosition);

    }

    public void fillMap(String c) {
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                graphicViev[i][j] = c;
            }
        }
    }

    public void showMap() {

        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                System.out.print(graphicViev[i][j]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public String[][] getGraphicViev() {
        return graphicViev;
    }

    public Set<Station> getStations() {
        return stations;
    }
}
