package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;
/**
 * Command to print the average of minimal points of all collection elements.
 */
public class AverageOfMinimalPoint extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            long averagePoint = 0;
            for (LabWork labWork : LabWorkHelper.getCollection()) {
                averagePoint = averagePoint + labWork.getMinimalPoint();
            }
            averagePoint = averagePoint / LabWorkHelper.getCollection().size();
            return "Average of minimal points = " + averagePoint;
        }
    }
}
