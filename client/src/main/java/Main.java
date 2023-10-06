import commands.Command;
import commands.Help;
import network.TCPClient;
import utils.IOHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TCPClient client = new TCPClient();
        Command help = new Help();

        while(true){
            IOHandler.print("> ");
            String input = scanner.nextLine();
            client.sendRequest(input +" placeholderArg");
        }
    }
}
