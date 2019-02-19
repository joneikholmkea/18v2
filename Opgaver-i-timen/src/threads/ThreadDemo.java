package threads;

public class ThreadDemo {

    static int amountOfWorkDone = 0;

    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        Thread thread1 = new Thread(worker1);

        Worker2 worker2 = new Worker2();
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();

    }


}
