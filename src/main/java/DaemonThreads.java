/**
 Daemon threads are low prio threads that runs in the background such as garbage collector
 Usually it is created for I/O operations or services (e.g.: NFC, Bluetooth)
 Daemon threads are terminated by the JVM when all other worker threads are terminated
Daemon thread is going to be terminated by the JVM when all other threads are finished.
 */

public class DaemonThreads {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon thread is running...");
            }
        });


        Thread normalThread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Normal thread is finishing...");

        });

        daemonThread.setDaemon(true);
        daemonThread.start();
        normalThread.start();
    }
}
