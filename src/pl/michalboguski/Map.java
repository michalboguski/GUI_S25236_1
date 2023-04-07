package pl.michalboguski;

import java.util.Random;

public class Map {
    private int width;
    private int height;
    String[][] worldMap;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.worldMap = new String[height][width];

    }

    public void fillMap(String c) {
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                worldMap[i][j] = c;
            }
        }
    }

    public void createStationsInRandomPosition(String stationChar, String emptyChar, Station... stations) {
        Random n = new Random();
        int xPos = 0;
        int yPos = 0;

        fillMap(emptyChar);

        for (Station station : stations) {
            xPos = n.nextInt(width);
            yPos = n.nextInt(height);
            if (worldMap[yPos][xPos] != stationChar) {
                station.position = new Coorrdinates(xPos, yPos);
                worldMap[yPos][xPos] = stationChar;
            }
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
}
