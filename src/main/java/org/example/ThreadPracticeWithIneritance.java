package org.example;

//Another fundamental way to create threads is to extend Thread class
class Runner3 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 3: " + i);
        }
    }
}

class Runner4 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner 4: " + i);
        }
    }
}
public class ThreadPracticeWithIneritance {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Runner3();
        Thread t4 = new Runner4();

        t3.start();
        t4.start();

        //We can wait for the thread to finish: join()
        //Waits for this thread to die.
        t3.join();
        t4.join();


        System.out.println("Finished threads...");
    }
}
