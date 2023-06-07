package src.commands.AllCommands;

import src.vehicleData.VehicleCollection;
import src.commands.Command;
import src.commands.ArgsChecker;

/**
 * The type Info.
 */
public class Info implements Command {
    /** Метод, выводящий информацию о коллекции
     * @see ArgsChecker#argsChecker(int)
     * @see VehicleCollection#getInfo() */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        VehicleCollection.getInfo();
    }
    @Override
    public String description() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}