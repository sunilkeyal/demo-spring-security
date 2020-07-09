package info.keyal.demo.thread;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        // Create thread from extending Thread
        MyThread myThreadOne = new MyThread();
        System.out.println("Waiting for first thread to start");
        Thread.sleep(5000);
        myThreadOne.start(); // What you start a thread, the run method of the thread is run.

        // Create thread from implementing Runnable
        System.out.println("Waiting for second thread to start");
        Thread.sleep(5000);
        MyRunnable myRunnable = new MyRunnable();
        Thread myThreadTwo = new Thread(myRunnable);
        myThreadTwo.start();

        // Create thread by implementing Runnable in Lambda
        Runnable myLambdaRunnable = () -> System.out.println("Thread Three Running");
        System.out.println("Waiting for third thread to start");
        Thread.sleep(5000);
        Thread myThreadThree = new Thread(myLambdaRunnable);
        myThreadThree.start();

    }
}

/**
 * Create a thread by extending Thread
 */
class MyThread extends Thread {
int i;
    @Override
    public void run() {
        System.out.println(i);
        System.out.println("Thread One running");
    }
}

/**
 * Implementing Runnable
 * Thread can be created by passing an instance of this Runnable as constructor to the new Thread.
 *
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Two running");
    }
}

