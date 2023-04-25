/**
 * Every thread has its own stack memory, but all threads share the heap memory (shared memory space)
 */

public class MemoryManagement {

    public static int counter = 0;

    //Inconsistent result
    public static void increment() {
        counter++;
    }

    // We hae to make sure that this is only executed by a single thread at a given time
    public static synchronized void increment1() {
        counter++;
    }

    //Synchronized block is used to lock an object for any shared resource. Refers to the object.
    public void increment2() {
        synchronized (this){
            //counter++;
            //Otherclasss.increment(); ?
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();


        /**The join() method is a method that can be called on a thread object to wait for that thread to
         complete its execution before continuing with the execution of the main thread.*/
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The counter is: " + counter);

    }

    public static void main(String[] args) {
            process();
    }

}
