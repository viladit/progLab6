package commands;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Command to save collection to file.
 */
public class Save extends Command {
    @Override
    public String execute() {

        if (InputManager.getIsCommandArgument()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            try (FileOutputStream out = new FileOutputStream("data.csv")) {
                BufferedOutputStream bos = new BufferedOutputStream(out);
                for (LabWork labWork : LabWorkHelper.getCollection()) {
                    // example of output:  "Lab-1, 1, 1.0, 6, HARD, OPD"
                    String labWorkStr = labWork.getName() + ", " + labWork.getCoordinates().getX() + ", " + labWork.getCoordinates().getY() + ", " + labWork.getMinimalPoint() + ", " + labWork.getDifficulty() + ", " + labWork.getDiscipline().getName();
                    System.out.println(labWorkStr);
                    byte[] buffer = labWorkStr.getBytes();
                    bos.write(buffer, 0, buffer.length);
                    bos.write('\n');
                    bos.flush();
                }
                System.out.println("Коллекция сохранена в файл data.csv");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                try (FileOutputStream out = new FileOutputStream("dataReserved.csv")) {
                    BufferedOutputStream bos = new BufferedOutputStream(out);
                    for (LabWork labWork : LabWorkHelper.getCollection()) {
                        // example of output:  "Lab-1, 1, 1.0, 6, HARD, OPD"
                        String labWorkStr = labWork.getName() + ", " + labWork.getCoordinates().getX() + ", " + labWork.getCoordinates().getY() + ", " + labWork.getMinimalPoint() + ", " + labWork.getDifficulty() + ", " + labWork.getDiscipline().getName();
                        System.out.println(labWorkStr);
                        byte[] buffer = labWorkStr.getBytes();
                        bos.write(buffer, 0, buffer.length);
                        bos.write('\n');
                        bos.flush();
                    }
                    System.out.println("Коллекция сохранена в файл dataReserved.csv");
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }
            return "";
        }
        return "";
    }
}
