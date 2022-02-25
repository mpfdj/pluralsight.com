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

public class DemoAsyncExample3 {

    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();

        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            System.out.println("supplyIDs is running in " + Thread.currentThread().getName());
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        // Is asynchronous now as it returns a List of CompletableFuture now... runs in a different Thread in the ForkJoinPool
        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            System.out.println("fetchUsers Function is running in " + Thread.currentThread().getName());
            sleep(300);
            Supplier<List<User>> userSupplier = () -> {
                System.out.println("fetchUsers Supplier is running in " + Thread.currentThread().getName());
                return ids.stream().map(User::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier, executor2);  // Function and Supplier are both running in the same Thread pool now...
//            return CompletableFuture.supplyAsync(userSupplier);  // Supplier is now running in the main Thread...
        };

        // Display users
        Consumer<List<User>> displayer = users -> {
            System.out.println("displayer is running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };


        // Chain of tasks
        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);  // This task is executed in the main Thread as no executor1 Service has been defined (Thread pool) for this task

        completableFuture.thenComposeAsync(fetchUsers, executor2)  // Is equivalent of the flatMap of the Stream API. This task is executed in the main Thread as no executor1 Service has been defined (Thread pool) for this task
                                                                   // Run fetchUsers in a different pool
                .thenAcceptAsync(displayer,executor1);  // This task runs in a separate Thread


        // Wait 1 second so we can display the results
        sleep(1_000);


        executor1.shutdown();
        executor2.shutdown();

    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
