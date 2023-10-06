package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;

import java.util.TreeSet;
/**
 * Command to print all elements starts with argument.
 */
public class FilterStartsWithName extends Command {
    @Override
    public String execute() {
        if (!(InputManager.getIsCommandArgument())) {
            return "The command must have an argument!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Коллекция пустая!";
            } else {
                String argument = InputManager.getCommandArgument();
                TreeSet<LabWork> labWorkCopy = new TreeSet<LabWork>();
                for (LabWork labWork : LabWorkHelper.getCollection()) {
                    labWorkCopy.add(labWork);
                }
                boolean isElementFound = false;
                for (LabWork labWork : labWorkCopy) {
                    if (labWork.getName().contains(argument)) {
                        System.out.println(labWork.toString());
                        isElementFound = true;
                    }
                }
                if (!isElementFound) {
                    return "Wasn't found any matches";
                }
                return "";
            }
        }
    }
}
