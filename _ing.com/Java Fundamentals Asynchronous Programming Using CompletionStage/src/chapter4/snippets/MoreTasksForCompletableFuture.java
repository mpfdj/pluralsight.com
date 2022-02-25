package chapter4.snippets;

import lombok.extern.java.Log;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Log
public class MoreTasksForCompletableFuture {

    public static void main(String[] args) {

//        Supplier<List<Long>> getUserIDs = () -> List.of(1L, 2L, 3L);
//        Function<List<Long>, List<User>> getUsers = list -> readUsers(list);
//
//        CompletableFuture<List<User>> cf = CompletableFuture
//                .supplyAsync(getUserIDs)  // Takes a Supplier
//                .thenApply(getUsers);  // Takes a Function
//
        CompletableFuture<List<User>> cf = CompletableFuture
                .supplyAsync(() -> List.of(1L, 2L, 3L))  // Takes a Supplier
                .thenApply(list -> UserDatabase.readUsers(list));  // Takes a Function

        cf.thenRun(() -> log.info("The list of Users has been read from the database."));  // Takes a Runnable
        cf.thenAccept(users -> log.info(users.size() + " users have been read."));  // Takes a Consumer

        System.out.println(cf.join());
    }
}
