package chapter5.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {

        Supplier<List<Long>> supplyIDs = () -> {
            sleep(200);
            throw new IllegalStateException("No data");
//            return List.of(1L, 2L, 3L);
        };

        Function<List<Long>, List<User>> fetchUsers = ids -> {
            sleep(300);
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

        CompletableFuture<List<Long>> supply = CompletableFuture.supplyAsync(supplyIDs);
        CompletableFuture<List<Long>> exception = supply.exceptionally(e -> List.of());
        CompletableFuture<List<User>> fetch = exception.thenApply(fetchUsers);  // Wire fetch to exception
        CompletableFuture<Void> display = fetch.thenAccept(displayer);


        sleep(1_000);

        System.out.println("Supply  : done=" + supply.isDone() + " excpetion=" + supply.isCompletedExceptionally());
        System.out.println("Fetch   : done=" + supply.isDone() + " excpetion=" + supply.isCompletedExceptionally());
        System.out.println("Display : done=" + supply.isDone() + " excpetion=" + supply.isCompletedExceptionally());

        supply.join();  // Throws an Exception


    }



    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
