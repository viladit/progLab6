package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;

/**
 * Command to print reverted collection.
 */
public class PrintDescending extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } if (LabWorkHelper.getCollection().size() == 0) {
            return "Коллекция пустая!";
        } else {
            String[] arrayForReverse = new String[LabWorkHelper.getCollection().size()];
            int indexCounter = 0;
            for (LabWork labWork : LabWorkHelper.getCollection()) {
                arrayForReverse[indexCounter] = labWork.toString();
                indexCounter++;
            }
            for (int i = arrayForReverse.length-1; i >= 0; i--) {
                System.out.println(arrayForReverse[i]);
            }
            return "";
        }
    }
}
