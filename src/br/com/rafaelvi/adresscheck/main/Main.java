package br.com.rafaelvi.adresscheck.main;

import br.com.rafaelvi.adresscheck.models.Adress;
import br.com.rafaelvi.adresscheck.models.Builder;
import br.com.rafaelvi.adresscheck.models.CEP;
import br.com.rafaelvi.adresscheck.models.Connector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your adress CEP?");
        String input = keyboard.next();

        try {
            Connector connector = new Connector();
            String response = connector.sendRequest(input);
            System.out.println(response);

            CEP cep = connector.deserialize(response);
            System.out.println(cep);
            if (cep.cep() != null) {
                System.out.println("oi");
                Adress adress = new Adress(cep);
                Builder builder = new Builder();
                builder.buildFile(connector.serialize(adress));
            }

        } catch (RuntimeException e) { // For unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

    }
}
