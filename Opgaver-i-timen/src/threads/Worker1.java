package threads;

import java.util.Random;

public class Worker1 implements Runnable {

    Random random = new Random();
    // Lav en race, hvor hver tråd kæmper om at nå i mål først.
    int count = 0;
    @Override
    public void run() {
        while (count < 2000) {
            System.out.println("Worker 1:" + count);
//            try {
//                Thread.sleep(random.nextInt(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            count++;
            ThreadDemo.amountOfWorkDone = ThreadDemo.amountOfWorkDone + 1;
            try {
                wait(); // dette betyder, den Monitor lock som denne tråd
                // måtte have, bliver frigivet.
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker 1 er i mål");
        System.out.println("AmountOfWork :" + ThreadDemo.amountOfWorkDone);

    }

}
