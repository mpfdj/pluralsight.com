package chapter3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DemoCompletableFutureWithSupplier {


    public static void main(String[] args) {

        // Without the ExecutorService this Thread runs in the JVM main thread and exits when the program is finished.
        ExecutorService executor = Executors.newSingleThreadExecutor();


        Supplier<String> supplier = () -> {
            sleep(5);
            return Thread.currentThread().getName();
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executor);  // Expects a Supplier

//        completableFuture.complete("Too long!");

        String s = completableFuture.join();  // Main Thread will be blocked by this call
        System.out.println("Result 1 = " + s);





        // Demo: Forcing the Completion of a Task using Complete and Obtrude (opdringen)
//        completableFuture.complete("Too long!");  // This method waits for the CompletableFuture to finish
        completableFuture.obtrudeValue("Too long!");

        s = completableFuture.join();
        System.out.println("Result 2 = " + s);




        executor.shutdown();

    }


    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
