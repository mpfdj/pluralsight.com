package chapter4.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DemoAsyncExample2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            System.out.println("supplyIDs is running in " + Thread.currentThread().getName());
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        // Is asynchronous now as it returns a List of CompletableFuture now... runs in a different Thread in the ForkJoinPool
        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            sleep(300);
            Supplier<List<User>> userSupplier = () -> {
                System.out.println("fetchUsers is running in " + Thread.currentThread().getName());
//                return ids.stream().map(User::new).collect(Collectors.toList());
                return ids.stream().map(id -> new User(id)).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier);
        };

        // Display users
        Consumer<List<User>> displayer = users -> {
            System.out.println("displayer is running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };


        // Chain of tasks
        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);  // This task is executed in the main Thread as no executor Service has been defined (Thread pool) for this task

        completableFuture.thenCompose(fetchUsers)      // Is equivalent of the flatMap of the Stream API. This task is executed in the main Thread as no executor Service has been defined (Thread pool) for this task
//                .thenAcceptAsync(displayer,executor);  // This task runs in a separate Thread
                .thenAcceptAsync(displayer);  // This task runs in the main Thread


        // Wait 1 second so we can display the results
        sleep(1_000);


        executor.shutdown();

    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
