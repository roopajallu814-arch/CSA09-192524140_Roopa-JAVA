class ScannerThread extends Thread {

    public void run() {
        System.out.println("Thread class is running");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread class completed");
    }
}

class ScannerTask implements Runnable {

    public void run() {
        System.out.println("Runnable interface is running");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Runnable task completed");
    }
}

public class ScannerStations {

    public static void main(String[] args) {

        ScannerThread t1 = new ScannerThread();

        Thread t2 = new Thread(new ScannerTask());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread completed");
    }
}