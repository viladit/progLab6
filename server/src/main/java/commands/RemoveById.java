package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;

import java.util.TreeSet;
/**
 * Command to remove element with id = argument.
 */
public class RemoveById extends Command {
    @Override
    public String execute() {
        if (!(InputManager.getIsCommandArgument())) {
            return "The command must have an argument!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Коллекция пустая!";
            } else {
                int argument = 999999;
                try {
                    argument = Integer.parseInt(InputManager.getCommandArgument());
                } catch (NumberFormatException e) {
                    return  "Argument is not a digit!";
                }
                TreeSet<LabWork> labWorkCopy = new TreeSet<LabWork>();
                for (LabWork labWork : LabWorkHelper.getCollection()) {
                    labWorkCopy.add(labWork);
                }
                boolean isElementRemoved = false;
                for (LabWork labWork : labWorkCopy) {
                    if (labWork.getId() == argument) {
                        LabWorkHelper.getCollection().remove(labWork);
                        isElementRemoved = true;
                        break;
                    }
                }
                if (isElementRemoved) {
                    return "Removed element with ID - " + argument;
                } else {
                    return "Element wasn't found";
                }
            }
        }
    }
}
