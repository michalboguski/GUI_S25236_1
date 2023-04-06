package pl.michalboguski;

  //      Każda lokomotywa posiada podstawowe informacje o sobie
  //      (nazwę, stacja macierzysta, stacja
  //      źródłowa i docelowa transportu)
  //      oraz swój unikatowy numer identyfikacyjny nadawany automatycznie podczas tworzenia obiektu


public class Lovomotive {
    private String name;
    private Station homeStation;
    private Station sourceStation;
    private Station destinationStation;
    private int id;

    public static int freeID = 0;

    public Lovomotive(String name, Station homeStation, Station sourceStation, Station destinationStation) {
        this.name = name;
        this.homeStation = homeStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.id = ++freeID;
    }
}
