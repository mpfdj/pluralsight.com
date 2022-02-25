package chapter3;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnableTask = () -> System.out.println("Hello runnable");

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<?> future = service.submit(runnableTask);  // Returns a Future

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnableTask, service);  // runAsync returns a CompletableFuture





        Supplier<String> supplierTask = () -> "Hello supplier";

//        Future<?> future2 = service.submit(supplierTask);  // submit only accepts Runnable
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(supplierTask, service);  // supplyAsync returns a CompletableFuture
        System.out.println(completableFuture2.get());


    }

}
