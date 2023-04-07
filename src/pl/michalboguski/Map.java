package pl.michalboguski;

import java.util.Random;

public class Map {
    private int width;
    private int height;
    char[][] worldMap;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        this.worldMap = new char[width][height];

        fillMap(' ');
    }

    public void fillMap(char c){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                worldMap[i][j]= c;
            }
        }
    }

    public void createStationsInRandomPosition(char stationChar, Station... stations){
        Random n = new Random();
        int xPos = 0;
        int yPos = 0;

       fillMap(' ');

        for (Station station : stations) {
            xPos = n.nextInt(width);
            yPos = n.nextInt(height);
            if (worldMap[xPos][yPos] != stationChar) {
                station.position = new Coorrdinates(xPos, yPos);
                worldMap[xPos][yPos] = stationChar;
            }
        }
    }

}
