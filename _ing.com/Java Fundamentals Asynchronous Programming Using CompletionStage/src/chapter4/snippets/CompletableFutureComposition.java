package chapter4.snippets;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureComposition {

    public static void main(String[] args) {

        Supplier<List<Long>> userIdsSupplier = () -> remoteService();  // Returns the User ID's

        // Synchronous
        Function<List<Long>, List<User>> usersFromIds = ids -> fetchFromDB(ids);  // Returns the User objects

        CompletableFuture<List<User>> cf1 = CompletableFuture
                .supplyAsync(userIdsSupplier)
                .thenApply(usersFromIds);

        System.out.println(cf1.join());


        // Asynchronous
        Function<List<Long>, CompletableFuture<List<User>>> usersFromIds2 = ids -> fetchFromDB2(ids);  // Returns the User objects

        CompletableFuture<List<User>> cf2 = CompletableFuture
                .supplyAsync(userIdsSupplier)
                .thenCompose(usersFromIds2);  // Work similar to FlatMap method from the Stream API


//        System.out.println(cf2.join());




    }


    public static List<Long> remoteService() {
        return List.of(1L, 2L, 3L);
    }

    public static List<User> fetchFromDB(List<Long> ids) {
        return UserDatabase.readUsers(ids);
    }

    public static CompletableFuture<List<User>> fetchFromDB2(List<Long> ids) {
        // Need to figure out how to return a CompletableFuture containing a list
        return (CompletableFuture<List<User>>) UserDatabase.readUsers(ids);
    }


}