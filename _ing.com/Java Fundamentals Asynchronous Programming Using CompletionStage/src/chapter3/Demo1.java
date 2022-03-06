package chapter3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runnableTask = () -> {
            System.out.println("I'm running async in thread: " + Thread.currentThread().getName());
        };

        CompletableFuture.runAsync(runnableTask, executor);

        executor.shutdown();

    }


}
