package src.commands.AllCommands;


import src.vehicleData.Vehicle;
import src.vehicleData.VehicleCollection;
import src.commands.Command;
import java.util.Comparator;
import src.commands.ArgsChecker;


/**
 * The type Min by capacity.
 */
public class MinByCapacity implements Command {
    private void minByCapacityPrinter() {
        System.out.println(VehicleCollection.getVehicle().stream().min(Comparator.comparingLong(Vehicle::getCapacity)).get());
    }
    /** Метод, выполняющий команду с помощью minByCapacityPrinter
     * @see MinByCapacity#minByCapacityPrinter()
     * @see ArgsChecker#argsChecker(int) (int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        if (VehicleCollection.getVehicle().size() != 0) {
            minByCapacityPrinter();
        } else {
            System.out.println("Коллекция пуста");
        }
    }
    @Override
    public String description() {
        return "min_by_capacity: вывести любой объект из коллекции, значение поля capacity которого является минимальным";
    }
}