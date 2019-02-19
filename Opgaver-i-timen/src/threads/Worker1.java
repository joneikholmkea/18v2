package threads;

import java.util.Random;

public class Worker1 implements Runnable {

    Random random = new Random();
    // Lav en race, hvor hver tråd kæmper om at nå i mål først.
    @Override
    public void run() {
        while (true) {
            System.out.println("Worker 1 kører...");
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
