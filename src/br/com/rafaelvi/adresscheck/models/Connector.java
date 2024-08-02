package br.com.rafaelvi.adresscheck.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connector {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request;
    HttpResponse<String> response;
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();;

    public String sendRequest(String adress){
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + adress +"/json/"))
                .build();
        System.out.println();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public CEP deserialize(String json) throws IllegalStateException{
        try {
            return gson.fromJson(json, CEP.class);
        } catch (IllegalStateException | JsonSyntaxException e) {
            System.err.println("Incorrect CEP, please review it.");
            throw e; // Re-throw for further handling
        }
    }

    public String serialize(Adress adress){
        return gson.toJson(adress);
    }
}
