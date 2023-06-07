package src.commands.AllCommands;
import src.vehicleData.*;
import src.commands.Command;
import src.commands.ArgsChecker;
import src.commands.Invoker;
import src.database.DatabaseConnection;
import src.database.UserAuthentication;
import java.util.List;

/**
 * The type Remove all by type.
 */
public class RemoveAllByType implements Command {
    /** Метод, удаляющий из коллекции все объекты с заданным типом
     * @see VehicleCollection#updateFromDB()
     * @see DatabaseConnection#executeStatement(String) */
    private void removerByType(Vehicle thisVehicle) {
        List<Vehicle> list = VehicleCollection.getVehicle().stream().filter(vehicle -> vehicle.getType().equals(VehicleType.valueOf(Invoker.getSplit()[1].trim()))).toList();
        if (list.isEmpty()) {
            System.out.println("Объектов такого типа не существует");
        } else {
            int beforeSize = VehicleCollection.getVehicle().size();
            list.forEach(vehicle -> DatabaseConnection.executeStatement("delete from dragons where type = " + vehicle.getType() + " and creator = '" + UserAuthentication.getCurrentUser() + "'"));
            VehicleCollection.updateFromDB();
            System.out.println("Количество удалённых объектов: " + (beforeSize - VehicleCollection.getVehicle().size()) + "\n P.S. (Вы можете удалять только те объекты, создателем которых являетесь)");
        }
    }
    /** Метод, находящий заданного дракона в коллекции и вызывающий метод removerGreater
     * @see RemoveAllByType#removerByType(Vehicle)
     * @see ArgsChecker#argsChecker(int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(1);
        try {
            List<Vehicle> matchedVehicle = VehicleCollection.getVehicle().stream().filter(vehicle -> vehicle.getType().equals(VehicleType.valueOf(Invoker.getSplit()[1].trim()))).toList();
            if (matchedVehicle.isEmpty()) System.out.println("Заданного объекта не существует");
            else removerByType(matchedVehicle.get(0));
        } catch (NumberFormatException ex) {
            throw new NullPointerException();
        }
    }
    @Override
    public String description() {
        return "remove_all_by_type type : удалить из коллекции все элементы, значение поля type которого эквивалентно заданному";
    }
}