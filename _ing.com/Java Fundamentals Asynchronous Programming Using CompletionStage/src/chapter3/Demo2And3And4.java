package chapter3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


// CompletableFuture With Supplier
public class Demo2And3And4 {


    public static void main(String[] args) {

        // Without the ExecutorService this Thread runs in the JVM main thread and exits when the program is finished.
        ExecutorService executor = Executors.newSingleThreadExecutor();


        Supplier<String> supplier = () -> {
            sleep(5);
            return Thread.currentThread().getName();
        };

        CompletableFuture<String> task = CompletableFuture.supplyAsync(supplier, executor);  // Expects a Supplier


        sleep(6);  // Wait fot the supplier to finish


        task.complete("Too long! by Complete!");

        String s1 = task.join();  // Main Thread will be blocked by this call
        System.out.println("Result 1 = " + s1);





        // Demo: Forcing the Completion of a Task using Complete and Obtrude (opdringen)
//        completableFuture.complete("Too long!");


        task.obtrudeValue("Too long by Obtrude!");

        String s2 = task.join();
        System.out.println("Result 2 = " + s2);




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
