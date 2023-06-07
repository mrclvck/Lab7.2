package src.commands.AllCommands;

import src.commands.Command;
import src.commands.ArgsChecker;
import src.commands.Invoker;

/**
 * The type Exit.
 */
public class Exit implements Command {
    /** Метод, завершающий работу программы
     * @see ArgsChecker#argsChecker(int) (int)
     * @see Invoker#setProgramRunning(boolean) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        Invoker.setProgramRunning(false);
    }
    @Override
    public String description() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}