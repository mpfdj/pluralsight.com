package httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import static java.net.http.HttpResponse.*;

public class HttpClientAsync {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest req = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> resFuture = httpClient.sendAsync(req, BodyHandlers.ofString());
        resFuture.thenAccept(res -> System.out.println(res.version()));
        resFuture.join();
    }


}
