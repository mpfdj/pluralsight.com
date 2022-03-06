package chapter4.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


// Demo with chain of tasks
public class DemoAsyncExampleIntroduction {

    public static void main(String[] args) {

        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        Function<List<Long>, List<User>> fetchUsers = ids -> {
            sleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        // Display users
        Consumer<List<User>> displayer = users -> users.forEach(System.out::println);


        // This task is executed in the main Thread as no executor Service has been defined (Thread pool)
        // Chain of tasks
        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);
        completableFuture.thenApply(fetchUsers)
                .thenAccept(displayer);


        // Wait 1 second so we can display the results
        sleep(1_000);

    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
