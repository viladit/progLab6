package commands;

import input.InputManager;
/**
 * Command to print the list of command with their description.
 */
public class Help extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            System.out.println("info: вывести в стандартный поток вывода информации о коллекции(тип, дата инициализации, количество элементов и т.д.)");
            System.out.println("show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
            System.out.println("add {element}: добавить новый элемент в коллекцию");
            System.out.println("update_id {element}: обновить значение элемента коллекции, id которого равен заданному");
            System.out.println("remove_by_id id: удалить элемент из коллекции по его id");
            System.out.println("clear: очистить коллекцию");
            System.out.println("save: сохранить коллекцию в файл");
            System.out.println("execute_script file_name: cчитать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
            System.out.println("exit: завершить программу (без сохранения в файл)");
            System.out.println("add_if_max {element}: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
            System.out.println("remove_greater {element}: удалить все элементы из коллекции, превышающие заданный");
            System.out.println("remove_lower {element}: удалить все элементы из коллекции, меньшие, чем заданный");
            System.out.println("average_of_minimal_point: удалить все элементы из коллекции, превышающие заданный");
            System.out.println("filter_starts_with_name name: вывести элементы, значение поля пате которых начинается с заданной подстроки");
            System.out.println("print_descending : вывести элементы коллекции в порядке убывания");
        }
        return "";
    }
    @Override
    public String getName(){
        return "help";
    }
}
