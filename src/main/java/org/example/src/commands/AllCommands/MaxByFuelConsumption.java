package src.commands.AllCommands;


import src.vehicleData.Vehicle;
import src.vehicleData.VehicleCollection;
import src.commands.Command;
import java.util.Comparator;
import src.commands.ArgsChecker;


/**
 * The type Max by fuel consumption.
 */
public class MaxByFuelConsumption implements Command {
    private void maxByMaxByFuelConsumptionPrinter() {
        System.out.println(VehicleCollection.getVehicle().stream().max(Comparator.comparingLong(Vehicle::getFuelConsumption)).get());
    }
    /** Метод, выполняющий команду с помощью minByCapacityPrinter
     * @see MaxByFuelConsumption#maxByMaxByFuelConsumptionPrinter()
     * @see ArgsChecker#argsChecker(int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        if (VehicleCollection.getVehicle().size() != 0) {
            maxByMaxByFuelConsumptionPrinter();
        } else {
            System.out.println("Коллекция пуста");
        }
    }
    @Override
    public String description() {
        return "max_by_fuel_consumption: вывести любой объект из коллекции, значение поля fuelConsumption которого является максимальным";
    }
}