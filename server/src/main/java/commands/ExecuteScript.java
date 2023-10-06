package commands;//package commands;
//
//import command.utils.CommandHelper;
//import input.InputManager;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.Scanner;
//
///**
// * Command to execute script.
// */
//public class ExecuteScript extends Command {
//    String commandArgument;
//    @Override
//    public String execute() {
//        try {
//            Deque<String> scriptsPathCopy;
//            if (CommandHelper.getScriptsPath().contains(InputManager.getCommandArgument()) && getName().equals("execute_script")) {
//                scriptsPathCopy = new ArrayDeque<>(CommandHelper.getScriptsPath());
//                CommandHelper.getScriptsPath().clear();
//                System.out.println("Обнаружена рекурсия!");
//            } else {
//                FileReader reader = new FileReader(InputManager.getCommandArgument());
//                Scanner scanner = new Scanner(reader);
//                CommandHelper.getScriptsPath().addLast(InputManager.getCommandArgument());
//                scriptsPathCopy = new ArrayDeque<>(CommandHelper.getScriptsPath());
//                while (scanner.hasNextLine()) {
//                    String commandLine = scanner.nextLine().trim();
//                    String[] input = commandLine.split(" ");
//                    while (input.length == 0 || input.length > 2) {
//                        commandLine = scanner.nextLine().trim();
//                        input = commandLine.split(" ");
//                    }
//                    String command = input[0];
//                    InputManager.setIsCommandArgument(false);
//                    if (input.length == 2) {
//                        commandArgument = input[1];
//                        InputManager.setIsCommandArgument(true);
//                        InputManager.setCommandArgument(commandArgument);
//                        CommandHelper.getCommands().get(command).setArgument(commandArgument);
//                    }
//                    CommandHelper.getCommands().get(command).execute();
//                }
//                return  "Скрипт " + scriptsPathCopy.pollLast() + " выполнен";
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл с названием " + InputManager.getCommandArgument() + " не найден");
//        }
//        return "";
//    }
//}
