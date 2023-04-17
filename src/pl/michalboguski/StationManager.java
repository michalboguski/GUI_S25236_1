package pl.michalboguski;


    public class StationManager extends Thread{
        Station station;
        public StationManager(Station station){
            this.station = station;
        }
        @Override
        public void run() {
            super.run();
            while (station != null) {
                for (Station linkedStation : station.getLinkedStation().keySet()) {
                    if (linkedStation.getLinkedStation().get(linkedStation) != null) {
                        station.getLinkedStation().replace(linkedStation, true);
                    }
                    // System.out.println("CHECKED" + station+":  "+station.getLinkedStation());

//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
//                System.out.println();
//                System.out.println("----------------------------------------------------------------------------------------------------------------");
//                System.out.println();

            }
        }
    }

