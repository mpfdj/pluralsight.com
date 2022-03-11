package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;


// Chapter 6
// See video "Writing the CompletableFuture Delayed start pattern"


public class ChainingTasks2 {
    private static List<User> myList = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Chain tasks pass result from one task to the next
        // https://www.baeldung.com/java-completablefuture
        // https://www.baeldung.com/java-9-completablefuture
        CompletableFuture<Void> start = new CompletableFuture<>();
        CompletableFuture<List<Long>> future1 = start.thenCompose(nil -> getUserIDs());

        future1.thenRun(() -> System.out.println("Fetching Users..."));
        CompletableFuture<List<User>> future2 = future1.thenCompose(ids -> getUsers(ids))
                .exceptionally(e -> List.of(new User(-1L)));

        future2.thenRun(() -> System.out.println("Composing MyList..."));
        future2.thenAccept(users -> composeMyList(users));

        start.complete(null);

        sleep(2_000);

        System.out.println(myList);


    }


    private static void composeMyList(List<User> users) {
        myList.addAll(users);
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
