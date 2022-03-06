package chapter4.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ThenCompose {

    public static void main(String[] args) {

        Supplier<List<Long>> userIdSupplier = () -> remoteService();

        Function<List<Long>, CompletableFuture<List<User>>> usersFromIds = ids -> fetchFromDB.apply(ids);


        CompletableFuture<List<User>> cf = CompletableFuture
                .supplyAsync(userIdSupplier)
                .thenCompose(usersFromIds);

        List<User> users = cf.join();

        System.out.println(users);

    }


    public static List<Long> remoteService() {

        return Arrays.asList(1l, 2l, 3l);
    }

    // This method is executed synchronously
    static Function<List<Long>, CompletableFuture<List<User>>> fetchFromDB = ids -> {
        Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
        return CompletableFuture.supplyAsync(userSupplier);
    };

}
