package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import command.utils.CheckCommand;
import input.InputManager;

import java.util.Scanner;
import java.util.TreeSet;
/**
 * Command to update element with id = argument.
 */
public class UpdateById extends Command {
    String[] labWorkParameters = new String[7];
    @Override
    public String execute() {
        if (!(InputManager.getIsCommandArgument())) {
            return "The command must have an argument!";
        } else {
            if (LabWorkHelper.getCollection().size() == 0) {
                return "Collection is empty!";
            } else {
                int argument = 999999;
                try {
                    argument = Integer.parseInt(InputManager.getCommandArgument());
                } catch (NumberFormatException e) {
                    return "Argument is not a digit!";
                }

                TreeSet<LabWork> labWorkCopy = new TreeSet<LabWork>();
                for (LabWork labWork : LabWorkHelper.getCollection()) {
                    labWorkCopy.add(labWork);
                }
                boolean isElementFound = false;
                for (LabWork labWork : labWorkCopy) {
                    if (labWork.getId() == argument) {
                        LabWorkHelper.getCollection().remove(labWork);
                        isElementFound = true;
                        break;
                    }
                }
                if (!isElementFound) {
                    return "Element wasn't found!";
                }
                Scanner scanner = new Scanner(System.in);

                System.out.println("Set name: ");
                String namePerson = scanner.nextLine();
                while (!CheckCommand.checkName(namePerson)) {
                    System.out.println("Set name: ");
                    namePerson = scanner.nextLine();
                }
                labWorkParameters[0] = namePerson;

                System.out.println("Set coordinate X in Long(greater than -1000): ");
                String xStr = scanner.nextLine();
                while (!CheckCommand.checkValueX(xStr)) {
                    System.out.println("Set coordinate X in Long(greater than -1000): ");
                    xStr = scanner.nextLine();
                }
                labWorkParameters[1] = xStr;

                System.out.println("Set coordinate Y in Float(greater than -512): ");
                String yStr = scanner.nextLine();
                while (!CheckCommand.checkValueY(yStr)) {
                    System.out.println("Set coordinate Y in Float(greater than -512): ");
                    yStr = scanner.nextLine();
                }
                labWorkParameters[2] = yStr;

                System.out.println("Set minimal point [6;20]: ");
                String minPoint = scanner.nextLine();
                while (!CheckCommand.checkMinimalPoint(minPoint)) {
                    System.out.println("Set minimal point [6;20]: ");
                    minPoint = scanner.nextLine();
                }
                labWorkParameters[3] = minPoint;

                System.out.println("Choose difficulty(HARD, VERY_HARD, IMPOSSIBLE, INSANE, HOPELESS): ");
                String difficulty = scanner.nextLine();
                while (!CheckCommand.checkDifficulty(difficulty)) {
                    System.out.println("Choose difficulty(HARD, VERY_HARD, IMPOSSIBLE, INSANE, HOPELESS): ");
                    difficulty = scanner.nextLine();
                }
                labWorkParameters[4] = difficulty;

                System.out.println("Set discipline: ");
                String discipline = scanner.nextLine();
                while (!CheckCommand.checkDiscipline(discipline)) {
                    System.out.println("Set discipline: ");
                    discipline = scanner.nextLine();
                    if (discipline.equals("")) {
                        discipline = null;
                    }
                }
                labWorkParameters[5] = discipline;

                LabWork lab = new LabWork(labWorkParameters);
                lab.setId((long) argument);
                LabWorkHelper.getCollection().add(lab);
                return "Element updated!";
            }
        }
    }
}
