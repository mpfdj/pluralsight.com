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

public class DemoAsyncExample5 {

    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newSingleThreadExecutor();


        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            System.out.println("supplyIDs is running in " + Thread.currentThread().getName());
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers1 = ids -> {
            sleep(150);
            Supplier<List<User>> userSupplier = () -> {
                System.out.println("fetchUsers1 is running in " + Thread.currentThread().getName());
                return ids.stream().map(User::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier);
        };

        // Simulate a database call which fetches the Users from a database
        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers2 = ids -> {
            sleep(5000);
            Supplier<List<User>> userSupplier = () -> {
                System.out.println("fetchUsers2 is running in " + Thread.currentThread().getName());
                return ids.stream().map(User::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier);
        };


        // Display users
        Consumer<List<User>> displayer = users -> {
            System.out.println("displayer is running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };


        // Chain of tasks
        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs, executor1);  // This task is executed in the main Thread as no executor Service has been defined (Thread pool) for this task

        CompletableFuture<List<User>> users1 = completableFuture.thenComposeAsync(fetchUsers1);  // When using acceptEither you should compose the CF asynchronous
        CompletableFuture<List<User>> users2 = completableFuture.thenComposeAsync(fetchUsers2);

        // This code is run when the CF is finished
        users1.thenRun(() -> System.out.println("Users 1"));
        users2.thenRun(() -> System.out.println("Users 2"));

        // Run the display when the first Computable future finishes don't wait for the other future
        // For acceptEither both Computable futures should return the same type
        users1.acceptEither(users2, displayer);


        // Wait 1 second so we can display the results
        sleep(6_000);


        executor1.shutdown();
    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
