package pl.michalboguski;

import java.util.Random;

public class Clock extends Thread{
    Lovomotive lovomotive;

    public Clock(Lovomotive lovomotive) {
        super();
        this.lovomotive = lovomotive;
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        boolean incrase;
        while (this.isAlive())
        {
            try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            incrase = random.nextBoolean();
            lovomotive.setSpeed(lovomotive.getSpeed()*(incrase ? 1.03 : 0.97));


        }
    }
}
