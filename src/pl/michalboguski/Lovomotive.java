package pl.michalboguski;

//          Dodatkowo lokomotywy posiadają przypisaną prędkość, z którą się porusza, a która co 1
//        sekundę prędkość będzie się zmniejszała lub zwiększała (losowo) o 3%. Na podstawie tej prędkości
//        należy uzależnić ruch składów pociągów po trasach.


public class Lovomotive {
    private String name;
    private Station homeStation;
    private Station sourceStation;
    private Station destinationStation;
    private double speed;
    private Clock clock;
    private int id;

    public static int freeID = 0;

    public Lovomotive(String name, Station homeStation, Station sourceStation, Station destinationStation, double speed) {
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.speed = speed;
        this.id = ++freeID;
        this.clock = new Clock(this);
        clock.start();

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
