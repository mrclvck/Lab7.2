package src.commands.AllCommands;

import src.commands.ArgsChecker;
import src.vehicleData.*;
import src.commands.Command;
import src.commands.Invoker;
import static src.vehicleData.VehicleType.getType;


/**
 * The type Count greater than type.
 */
public class CountGreaterThanType implements Command {
    /** Метод, выводящий количество драконов с заданным количеством глаз
     * @param vehicleType заданное количество глаз */
    private void getCountOfGreaterThanType(VehicleType vehicleType) {
        System.out.println("Количество техники типа больше чем заданный: " + VehicleCollection.getVehicle().stream().filter(vehicle -> VehicleType.getPower(vehicle.getType()) > VehicleType.getPower(vehicleType)).count());
    }
    /** Метод, выводящий количество элементов, значение поля head которых равно заданному с помощью getCountOfDragons
     * @see CountGreaterThanType#getCountOfGreaterThanType
     * @see ArgsChecker#argsChecker(int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(1);
        if (VehicleCollection.getVehicle().isEmpty()) {
            System.out.println("Коллекция пуста");
        } else {
            try {
                getCountOfGreaterThanType(getType(Invoker.getSplit()[1]));
            } catch (NumberFormatException e) {
                throw new NullPointerException();
            }
        }
    }
    @Override
    public String description() {
        return "count_by_head head : вывести количество элементов, значение поля head которых равно заданному";
    }
}
