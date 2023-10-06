package commands;

import Collection.utils.LabWorkHelper;
import input.InputManager;
/**
 * Command to clear the collection.
 */
public class Clear extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Коллекция пустая";
            } else {
                LabWorkHelper.getCollection().clear();
                return "Коллекция была очищена.";
            }
        }
    }
    @Override
    public String getName(){
        return "clear";
    }
}
