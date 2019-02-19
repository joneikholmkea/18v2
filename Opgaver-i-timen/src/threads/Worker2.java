package threads;

import java.util.Random;

public class Worker2 implements Runnable{


    Random random = new Random();

    @Override
    public void run() {
        while (true) {
            System.out.println("Worker 2 kører...");
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
