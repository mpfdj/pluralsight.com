package chapter3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class DemoSimpleCompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete(null);  // Please note that the complete method is being called here...
        };

        CompletableFuture.runAsync(task);  // Expects a Runnable

        Void nil = completableFuture.join();

        System.out.println("We are done");
    }

}
