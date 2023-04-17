package pl.michalboguski;

import java.util.Scanner;

public class Menu {

    public Menu() {
        startMenu();
    }

    private void startMenu() {
        System.out.println("Witaj w programie do symulacji i obsługi logistycznej lini kolejowych");
        System.out.println("=======================================================================");
        System.out.println("Co chcesz zrobić");
        System.out.println("0  - Wyjdz z Programu");
        System.out.println("1 - Pokaz liste stacj");
        System.out.println("2  - Pokaz mape");
        System.out.println("3  - Pokaz liste Pociagow");
        System.out.println("4  - NNNN");
        int pick = scanNumber(0,4);
        switch (pick){
            case 0 : {
                System.out.println("case0");
                break;}
            case 1 : {break;}
            case 2 : {break;}
            case 3 : {break;}
            case 4 : {break;}

        }
    }

    public int scanNumber(int startRange, int endRange){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe z zakresu: "+startRange+" - "+endRange);
        int scanned = scanner.nextInt();
        if (scanned >= startRange && scanned <= endRange) {
            return scanned;
        } else {
            scanned = scanNumber(startRange,endRange);
        }
        return  scanned;

    }
}
