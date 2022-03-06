package chapter3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureExample
{


    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Runnable and Supplier don't throw a checked exception'
//        Callable throws a checked exception

        Runnable runnableTask = () -> System.out.println("Hello runnable");
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(runnableTask);  // The CompletableFuture.runAsync only works with Runnables



        // CompletableFuture doesn't support Callable use a Supplier instead
        // Note: a Supplier doesn't accept any Checked Exceptions, that's the main difference with the Callable interface
        Supplier<String> supplierTask = () -> "Hello supplier";
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(supplierTask);
        System.out.println(completableFuture2.get());
    }
}
