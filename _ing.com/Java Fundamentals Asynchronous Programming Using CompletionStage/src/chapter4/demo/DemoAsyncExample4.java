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

public class DemoAsyncExample4 {

    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        ExecutorService executor3 = Executors.newSingleThreadExecutor();


        // Simulate an API call which fetches the User ID's
        Supplier<List<Long>> supplyIDs = () -> {
            System.out.println("supplyIDs is running in " + Thread.currentThread().getName());
            sleep(200);
            return Arrays.asList(1L, 2L, 3L);
        };

        // Simulate a database call which fetches the Users from a database
        Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
            sleep(250);
            Supplier<List<User>> userSupplier = () -> {
                System.out.println("fetchUsers is running in " + Thread.currentThread().getName());
                return ids.stream().map(User::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier, executor2);
        };

        // Simulate a database call which fetches the Emails from a database
        Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails = ids -> {
            sleep(3500);
            Supplier<List<Email>> userSupplier = () -> {
                System.out.println("fetchEmails is running in " + Thread.currentThread().getName());
                return ids.stream().map(Email::new).collect(Collectors.toList());
            };

            return CompletableFuture.supplyAsync(userSupplier, executor3);
        };


        // Chain of tasks
        CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs, executor1);  // This task is executed in the main Thread as no executor Service has been defined (Thread pool) for this task




        CompletableFuture<List<User>> userFuture = completableFuture.thenComposeAsync(fetchUsers);
        CompletableFuture<List<Email>> emailFuture = completableFuture.thenComposeAsync(fetchEmails);

        // The BiConsumer is executed when both the user and email futures are completed
        userFuture.thenAcceptBoth(emailFuture,
                (users, emails) -> {
                    System.out.println("number of users is: " + users.size() + " number of emails is: " + emails.size());
                });

        // Wait 1 second so we can display the results
//        sleep(4_000);

        userFuture.join();
        emailFuture.join();
//        completableFuture.join();

        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();

    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
