package chapter6.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.*;

public class Demo3 {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.amazon.com"))
                .build();

        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        future.thenAcceptAsync(response -> {
                    String body = response.body();
                    System.out.println("Length body is: " + body.length() + " [" + Thread.currentThread().getName() + "]");

                }, executor)
                .thenRun(() -> System.out.println("Done!"))
                .join();

        executor.shutdown();


    }
}
