package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;


// Chapter 6
// See video "Writing the CompletableFuture Delayed start pattern"


public class ChainingTasks {
    private static List<User> myList = new ArrayList<>();

    public static void main(String[] args) {

        // Chain tasks pass result from one task to the next
        // https://stackoverflow.com/questions/43019126/completablefuture-thenapply-vs-thencompose#:~:text=thenCompose()%20is%20better%20for,one%20use%20case%20then%20other.
        CompletableFuture<Void> start = new CompletableFuture<>();
        start.thenCompose(nil -> getUserIDs())
                .thenCompose(ids -> getUsers(ids))
                .thenApply(users -> myList.addAll(users));

        start.complete(null);

        sleep(2_000);

        System.out.println(myList);



    }


    // Simulate an API call which fetches the User ID's
    private static CompletableFuture<List<Long>> getUserIDs() {
        sleep(250);
        Supplier<List<Long>> supplier = () -> {
            System.out.println("getUserIDs is running in " + Thread.currentThread().getName());
            return Arrays.asList(1L, 2L, 3L);
        };
        return CompletableFuture.supplyAsync(supplier);
    }

    // Simulate a Database call which fetches the User data
    private static CompletableFuture<List<User>> getUsers(List<Long> userIDs) {
        sleep(1_000);
        Supplier<List<User>> supplier = () -> {
            System.out.println("getUsers is running in " + Thread.currentThread().getName());
            // return userIDs.stream().map(User::new).collect(Collectors.toList());  // Using method reference
            return userIDs.stream().map(id -> new User(id)).collect(Collectors.toList());  // Using lambda
        };
        return CompletableFuture.supplyAsync(supplier);
    }


    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
