package threads;

import java.util.Random;

public class Worker2 implements Runnable{


    Random random = new Random();
    // Lav en race, hvor hver tråd kæmper om at nå i mål først.
    int count = 0;
    @Override
    public void run() {
        while (count < 2000) {
            System.out.println("Worker 2:" + count);
//            try {
//                Thread.sleep(random.nextInt(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            count++;
            ThreadDemo.amountOfWorkDone = ThreadDemo.amountOfWorkDone + 1;
        }
        System.out.println("Worker 2 er i mål");
        System.out.println("AmountOfWork :" + ThreadDemo.amountOfWorkDone);
    }
}
