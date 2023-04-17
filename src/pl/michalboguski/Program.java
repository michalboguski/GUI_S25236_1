package pl.michalboguski;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Program {



    public static void main(String[] args) {
        new Menu();


        WorldMap testMap = new WorldMap(15,15, " . ");
        Coorrdinates p1 = new Coorrdinates(1,3);
        Coorrdinates p2 = new Coorrdinates(9,8);
        Coorrdinates p3 = new Coorrdinates(8,2);
        Coorrdinates p4 = new Coorrdinates(5,5);
        Coorrdinates p5 = new Coorrdinates(6,7);
        Coorrdinates p6 = new Coorrdinates(9,0);
        Coorrdinates p7 = new Coorrdinates(3,1);
        Coorrdinates p8 = new Coorrdinates(4,8);
        Coorrdinates p9 = new Coorrdinates(0,9);
        Coorrdinates p10 = new Coorrdinates(1,7);

        Station s1 = new Station("S1",p1);
        Station s2 = new Station("S2",p2);
        Station s3 = new Station("S3",p3);
        Station s4 = new Station("S4",p4);
        Station s5 = new Station("S5",p5);
        Station s6 = new Station("S6",p6);
        Station s7 = new Station("S7",p7);
        Station s8 = new Station("S8",p8);
        Station s9 = new Station("S9",p9);
        Station s10 = new Station("S10",p10);

        List<Station> s = Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
      // testMap.createRandomStations(10,"C");
       // testMap.createRandomStations(10,"B");

        testMap.stations.addAll(s);
        testMap.uptadeStationPositions();
        testMap.showMap();
        testMap.establishConnections(3);

        Lovomotive l1 = new Lovomotive("Lokomtywa1",s10,s6,s9,100,10);
        Carriage c1 = new HavyCarriage(new Sender("ADAM"),new Security[]{Security.HEAVY_DOOR},10000,20000);
        Carriage c2 = new HavyCarriage(new Sender("EWA"),new Security[]{Security.HEAVY_DOOR},10000,22000);
        Carriage c3 = new HavyCarriage(new Sender("DAMIAN"),new Security[]{Security.HEAVY_DOOR},10000,21000);

        LinkedList<Carriage> carriages = new LinkedList<>(Arrays.asList(c1,c2,c3));

        Train t1 = new Train(testMap,l1, carriages, l1.getMaxPull(), s1,s2);
        t1.getRoute();
            t1.start();
        Train t2 = new Train(testMap,l1, carriages, l1.getMaxPull(), s1,s2);
        t2.getRoute();
        t2.start();
//        Train t3 = new Train(testMap,l1, carriages, l1.getMaxPull(), s2,s1);
//        t3.getRoute();
//        t3.start();
//        Train t4 = new Train(testMap,l1, carriages, l1.getMaxPull(), s2,s1);
//        t4.getRoute();
//        t4.start();



    }
}
