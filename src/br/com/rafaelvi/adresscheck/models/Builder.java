package br.com.rafaelvi.adresscheck.models;

import java.io.FileWriter;
import java.io.IOException;

public class Builder {

    public void buildFile(String json){
        try {
        FileWriter fileWriter = new FileWriter("adress.json");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
