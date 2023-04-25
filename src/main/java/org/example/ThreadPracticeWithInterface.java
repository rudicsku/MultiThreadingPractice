package org.example;

//One fundamental way to create threads in java is to implement Runnable interface
class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner 1: " + i);
        }
    }
}

//class Runner2 implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Runner 2: " + i);
//        }
//    }
//}

public class ThreadPracticeWithInterface {

    public static void main(String[] args) {
        //This is an example for the time-slicing algorithm, this is not parallel execution
        //We are using a single CPU, the two threads are executed by the same processor
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Runner 2: " + i);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
