package src.commands.AllCommands;
import src.commands.Command;
import src.vehicleData.*;
import src.commands.ArgsChecker;

/**
 * The type Show.
 */
public class Show implements Command {
    /** Метод, выводящий все элементы коллекции
     * @see ArgsChecker#argsChecker(int)
     * @see Vehicle#toString() */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        if (VehicleCollection.getVehicle().isEmpty()) {
            System.out.println("Коллекция пуста");
        } else {
            VehicleCollection.getVehicle().forEach(System.out::println);
        }
    }
    @Override
    public String description() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}