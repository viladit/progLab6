package network;

import commands.*;
import requests.Request;
import utils.CommandHelper;
import utils.IOHandler;
import utils.LabWorkCreator;

import java.nio.charset.StandardCharsets;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.io.*;

public class TCPClient {

    private String host = "localhost";
    private int port = 3333;
    private SocketChannel clientSocket;

    public boolean connectToServer() throws IOException {
        try {
            this.clientSocket = SocketChannel.open(new InetSocketAddress(host, port));
            return true;
        } catch (IOException ioe) {
            IOHandler.println("Ошибка при подключении: " + ioe.getMessage());
            return false;
        }
    }

    public void closeConnection() throws IOException {
        this.clientSocket.close();
    }

    public boolean sendRequest(String input) throws IOException, InterruptedException {
        String[] tokens = input.split("\\s+");
        String command = tokens[0];
        String argument = tokens[1];

        if(!CommandHelper.commandList().containsKey(command)){
            IOHandler.println("Команды " + "\u001B[31m" + command + "\u001B[0m" +" не существует");
            return false;
        }

        if(command.equals("exit")){
            new Exit().execute(argument);
            return true;
        }

        if(command.equals("help")){
            new Help().execute(argument);
            return true;
        }

//        if(command.equals("execute_script")){
//            new ExecuteScript(CommandHelper.commandList(), this).execute(argument);
//            return true;
//        }

        if(!CommandHelper.argCheckMap().get(command).argCheck(argument)){
            return false;
        }

        if(connectToServer()){
            ObjectOutput objectOutput = new ObjectOutputStream(this.clientSocket.socket().getOutputStream());
            InputStream in = new BufferedInputStream(clientSocket.socket().getInputStream());

            if(command.equals("add") || command.equals("update")){
                objectOutput.writeObject(new Request(command, argument, new LabWorkCreator().labWorkCreate()));
            } else {
                objectOutput.writeObject(new Request(command, argument, null));
            }

            String str_in = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            IOHandler.print(str_in);
            in.close();
            objectOutput.close();
            closeConnection();
        }
        return true;
    }

}