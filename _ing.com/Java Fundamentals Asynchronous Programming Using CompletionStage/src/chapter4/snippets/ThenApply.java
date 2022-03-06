package chapter4.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThenApply {

    public static void main(String[] args) {

        Supplier<List<Long>> userIdSupplier = () -> remoteService();

        Function<List<Long>, List<User>> usersFromIds = ids -> fetchFromDB(ids);


        CompletableFuture<List<User>> cf = CompletableFuture
                .supplyAsync(userIdSupplier)
                .thenApply(usersFromIds);

        List<User> users = cf.join();

        System.out.println(users);

    }


    public static List<Long> remoteService() {
        return Arrays.asList(1l, 2l, 3l);
    }

    // This method is executed synchronously
    public static List<User> fetchFromDB(List<Long> ids) {
        User isabella = new User(ids.get(0),"Isabella");
        User kim = new User(ids.get(1), "Kim");
        User miel = new User(ids.get(2),"Miel");

        List<User> users = new ArrayList<>();
        users.add(isabella);
        users.add(kim);
        users.add(miel);

        return users;
    }


}
