package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileOperations {

    public static void editJsonFile(String value, String opCode) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        HomeDevice homeDevice = parseJsonFile();
        if (opCode.equals("1")){
            homeDevice.setLight(value);
        }else if (opCode.equals("2")){
            homeDevice.setWindow(value);
        }else if (opCode.equals("3")){
            homeDevice.setDoor(value);
        }else {
            System.out.println("Error, no statement was executed...");
        }

        FileWriter fileWriter = new FileWriter("HomeDevices.json", false);
        gson.toJson(homeDevice, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }

    public static HomeDevice parseJsonFile() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("HomeDevices.json"));
        return gson.fromJson(reader, HomeDevice.class);

    }
}
