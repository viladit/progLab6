package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;
/**
 * Command to print collection elements.
 */
public class Show extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Коллекция пустая!";
            } else {
                for (LabWork labwork : LabWorkHelper.getCollection()) {
                    System.out.println(labwork.toString());
                }
            }
        }
        return "";
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
