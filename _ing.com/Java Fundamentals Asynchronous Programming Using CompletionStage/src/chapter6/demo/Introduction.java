package chapter6.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Introduction {

    public static void main(String[] args) {

        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            System.out.println("supplyIDs is running in " + Thread.currentThread().getName());
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        Function<List<Long>, List<User>> fetchUsers = ids -> {
            System.out.println("fetchUsers is running in " + Thread.currentThread().getName());
            sleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        // Display users
        Consumer<List<User>> displayer = users -> {
            System.out.println("displayer is running in " + Thread.currentThread().getName());
            users.forEach(System.out::println);
        };


        CompletableFuture<Void> start = new CompletableFuture<>();

        CompletableFuture<List<Long>> supply = start.thenApply(nil -> supplyIDs.get());
        CompletableFuture<List<User>> fetch = supply.thenApply(fetchUsers);
        CompletableFuture<Void> display = fetch.thenAccept(displayer);


        start.complete(null);

        // Wait 1 second so we can display the results (keep the main Thread alive)
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
