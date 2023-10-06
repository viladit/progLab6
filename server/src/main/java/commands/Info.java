package commands;

import Collection.utils.LabWorkHelper;
import input.InputManager;
/**
 * Command to print collection info.
 */
public class Info extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else if (LabWorkHelper.getCollection().size() == 0) {
            return "Коллекция пустая!";
        } else {
            System.out.println("Тип коллекции: " + LabWorkHelper.getCollection().getClass().toString());
            System.out.println("Дата инициализации: " + LabWorkHelper.getCollection().first().getCreationDate());
            System.out.println("Количество элементов: " + LabWorkHelper.getCollection().size());
        }
        return "";
    }
    @Override
    public String getName(){
        return "info";
    }
}
