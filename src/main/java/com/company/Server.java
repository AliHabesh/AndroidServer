package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;

public class Server {


    public void startServer(int port){
     try(var server = new ServerSocket(port)){
        var client = server.accept();
       //var output = new PrintWriter(client.getOutputStream(), true);
         OutputStream outputStream = client.getOutputStream();
         DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        var br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        HomeDevice homeDevice = JsonFileOperations.parseJsonFile();




        while (true){
            dataOutputStream.writeUTF(homeDevice.getLight()+"\n"+homeDevice.getDoor()+"\n"+homeDevice.getWindow());
            String opCode  = br.readLine();
            String dataFromClient = br.readLine();
            if (opCode.equals("exit")) break;

            if (opCode.equals("0")){
                System.out.println(dataFromClient);
            }else {
                System.out.println("This is the opCode -->: " + opCode);
                System.out.println("This is the data -->: " + dataFromClient);

                JsonFileOperations.editJsonFile(dataFromClient, opCode);
            }

        }

        }catch (Exception e){
         System.out.println(e.getMessage());
     }

    }

    public void menu(String opCode, String dataFromClient) throws IOException {
        Gson gson = new Gson();

        switch (opCode){

            //case "1" -> JsonFileOperations.editJsonFile();

        }
    }
}
