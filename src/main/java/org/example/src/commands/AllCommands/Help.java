package src.commands.AllCommands;

import src.commands.Command;
import src.commands.ArgsChecker;
import src.commands.Invoker;

/**
 * The type Help.
 */
public class Help implements Command {
    /** Метод, выводящий справку по командам
     * @see ArgsChecker#argsChecker(int)
     * @see Invoker#getCommandHashMap() */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        Invoker.getCommandHashMap().values().forEach(command -> System.out.println(command.description()));
    }
    @Override
    public String description() {
        return "help : вывести справку по доступным командам";
    }
}