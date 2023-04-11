package pl.michalboguski;

import java.util.Random;

public class Clock extends Thread{
    Lovomotive lovomotive;
    int interval;

    public Clock(Lovomotive lovomotive, int interval) {
        super();
        this.lovomotive = lovomotive;
        this.interval = interval;
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        boolean incrase;
        while (this.isAlive())
        {
            try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            incrase = random.nextBoolean();
            lovomotive.setSpeed(lovomotive.getSpeed()*(incrase ? 1.03 : 0.97));
           // System.out.println(lovomotive.getSpeed());

        }
    }
}
