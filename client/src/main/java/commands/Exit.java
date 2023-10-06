package commands;

import input.InputManager;
/**
 * Command to stop the program.
 */
public class Exit extends Command {
    @Override
    public String execute() {
        if (InputManager.getIsCommandArgument()) {
            return "У команды не должно быть аргумента!";
        } else {
            InputManager.setIsWorking(false);
            return "Завершение программы.";
        }
    }
    @Override
    public String getName(){
        return "exit";
    }
}
