package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ReadWebPage {
    public static void main(String[] args) {

        //Using HttpClient to perform a synchronous GET request
        /* HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.google.cl")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==200){
                System.out.println(response.body());
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        } */

        //Using HttpClient to perform a asynchronous GET request
        /* HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.google.cl")).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenAccept(System.out::println)
                        .join(); */

        //Error handling in HttpClient
        var client = HttpClient.newBuilder().build();
        var request = HttpRequest.newBuilder().uri(URI.create("http://www.vogella.com")).build();

        CompletableFuture<String> thenApplyAsync = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync((resp) -> {
                    int status = resp.statusCode();
                    if(status!=200){
                        System.out.println("Error: "+ resp.statusCode());
                        return "NOT VALID";
                    }else{
                        return resp.body();
                    }
                });
        thenApplyAsync.join();
    }
}