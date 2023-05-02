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
public class ThreadPracticeWithInheritance {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Runner3();
        Thread t4 = new Runner4();

        t3.start();
        t4.start();

        //We can wait for the thread to finish: join()
        //Waits for this thread to die.
        //When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.
        t3.join();
        t4.join();


        System.out.println("Finished threads...");
    }
}
