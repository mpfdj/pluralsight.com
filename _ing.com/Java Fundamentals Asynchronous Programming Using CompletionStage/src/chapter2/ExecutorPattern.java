package chapter2;

import java.util.concurrent.*;

public class ExecutorPattern {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            System.out.println("Hello I'm a Task1");
            sleep(3);
        };

        Runnable task2 = () -> {
            System.out.println("Hello I'm a Task2");
            sleep(3);
        };

        Runnable task3 = () -> {
            System.out.println("Hello I'm a Task3");
            sleep(3);
        };

        Future future;
        future = executor.submit(task1);
        future = executor.submit(task2);
        future = executor.submit(task3);

        System.out.println("hello you will see me right away");

        future.get();  // block until the task is done
//        future.cancel(true);

        System.out.println("hello you will see me after 3 seconds");

        executor.shutdown();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
