package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import command.utils.CheckCommand;
import input.InputManager;

import java.util.Scanner;
import java.util.TreeSet;
/**
 * Command to remove all elements with min. point greater than argument.
 */
public class RemoveGreater extends Command {
    String[] labWorkParameters = new String[7];
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Collection is empty!";
            }
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
            while (!CheckCommand.checkMinimalPoint(minPoint)) {
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

            int argument = 999999;
            TreeSet<LabWork> labWorkCopy = new TreeSet<LabWork>();
            for (LabWork labWork : LabWorkHelper.getCollection()) {
                labWorkCopy.add(labWork);
            }
            for (LabWork labWork : labWorkCopy) {
                if (labWork.getMinimalPoint() > lab.getMinimalPoint()) {
                    LabWorkHelper.getCollection().remove(labWork);
                }
            }
            return "Removed all elements greater, which minimal point is greater than - " + lab.getMinimalPoint();
        }
    }
}
