package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import command.utils.CheckCommand;
import input.InputManager;

import java.util.Scanner;
/**
 * Command to add a new person to the collection if its minimal point is max.
 */
public class AddIfMax extends Command {

    String[] labWorkParameters = new String[7];
    /**
     * Adds a new person to the collection if command argument is not exist.
     */
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String namePerson = scanner.nextLine();
            while (!CheckCommand.checkName(namePerson)) {
                System.out.println("Введите имя: ");
                namePerson = scanner.nextLine();
            }
            labWorkParameters[0] = namePerson;

            System.out.println("Введите координату X в типе данных Long(больше -1000): ");
            String xStr = scanner.nextLine();
            while (!CheckCommand.checkValueX(xStr)) {
                System.out.println("Введите координату X в типе данных Long(больше -1000): ");
                xStr = scanner.nextLine();
            }
            labWorkParameters[1] = xStr;

            System.out.println("Введите координату Y в типе данных Float(больше -512): ");
            String yStr = scanner.nextLine();
            while (!CheckCommand.checkValueY(yStr)) {
                System.out.println("Введите координату Y в типе данных Float(больше -512): ");
                yStr = scanner.nextLine();
            }
            labWorkParameters[2] = yStr;

            System.out.println("Введите минимальный балл за эту работу [6;20]: ");
            String minPoint = scanner.nextLine();
            while (!CheckCommand.checkValueX(minPoint)) {
                System.out.println("Введите минимальный балл за эту работу [6;20]: ");
                minPoint = scanner.nextLine();
            }
            labWorkParameters[3] = minPoint;

            System.out.println("Введите сложность(HARD, VERY_HARD, IMPOSSIBLE, INSANE, HOPELESS): ");
            String difficulty = scanner.nextLine();
            while (!CheckCommand.checkDifficulty(difficulty)) {
                System.out.println("Введите сложность(HARD, VERY_HARD, IMPOSSIBLE, INSANE, HOPELESS): ");
                difficulty = scanner.nextLine();
            }
            labWorkParameters[4] = difficulty;

            System.out.println("Введите дисциплину: ");
            String discipline = scanner.nextLine();
            while (!CheckCommand.checkDiscipline(discipline)) {
                System.out.println("Введите дисциплину: ");
                discipline = scanner.nextLine();
                if (discipline.equals("")) {
                    discipline = null;
                }
            }
            labWorkParameters[5] = discipline;

            LabWork lab = new LabWork(labWorkParameters);
            if (lab.getMinimalPoint() > LabWorkHelper.getCollection().last().getMinimalPoint()) {
                LabWorkHelper.getCollection().add(lab);
                return "Element added!";
            } else {
                return "Element wasn't added!\nMinimal point of new element <= of the maximum one in the collection";
            }
        }
    }
    @Override
    public String getName(){
        return "add";
    }
}
