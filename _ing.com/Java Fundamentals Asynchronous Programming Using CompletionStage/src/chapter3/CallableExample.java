package chapter3;

import chapter4.demo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-completablefuture
// https://howtodoinjava.com/java/multi-threading/executorservice-invokeall/

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> callable1 = () -> "Hello I'm Callable1";
        Callable<String> callable2 = () -> "Hello I'm Callable2";
        Callable<String> callable3 = () -> "Hello I'm Callable3";

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(callable1);
        callables.add(callable2);
        callables.add(callable3);

        List<Future<String>> futures = executor.invokeAll(callables);


        List<String> result = futures.stream().map(CallableExample::apply).collect(Collectors.toList());
//        List<String> result2 = futures.stream().map(f -> f.get().toString()).collect(Collectors.toList());



        executor.shutdown();

        System.out.println(result);

    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String apply(Future<String> f) {
        try {
            return f.get();
        } catch (InterruptedException | ExecutionException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
