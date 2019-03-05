package threads;

public class ThreadDemo {


    public static void main(String[] args) {

        new ThreadDemo().runserver();

    }

    private void runserver(){
        new Thread(new LittleWorker()).start();
        new Thread(new LittleWorker()).start();
    }

    class LittleWorker implements Runnable{

        @Override
        public void run() {
            while (true) {
                System.out.println("little worker kører");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {


                }
            }

        }
    }

}
