
package src.commands.AllCommands;

import src.commands.Command;
import src.commands.Invoker;
import src.database.DatabaseConnection;
import src.database.UserAuthentication;
import src.vehicleData.*;
import java.util.List;
import src.commands.ArgsChecker;

/**
 * The type Remove by id.
 */
public class RemoveById implements Command {
    /** Метод, удаляющий дракона по значению id
     * @param id объекта, которого надо удалить
     * @see DatabaseConnection#executeStatement(String)
     * @see VehicleCollection#updateFromDB() */
    private void removerById(long id) {
        List<Vehicle> matchedVehicle = VehicleCollection.getVehicle().stream().filter((vehicle -> vehicle.getId() == id)).toList();
        if (matchedVehicle.isEmpty()) {
            System.out.println("Такого объекта не существует");
        } else {
            int beforeSize = VehicleCollection.getVehicle().size();
            DatabaseConnection.executeStatement("delete from vehicle where id = " + matchedVehicle.get(0).getId() + " and creator = '" + UserAuthentication.getCurrentUser() + "'");
            VehicleCollection.updateFromDB();
            if (beforeSize == VehicleCollection.getVehicle().size()) {
                System.out.println("Вы не можете удалить этот объект, так как он создан другим пользователем");
            } else {
                System.out.println("Объект успешно удалён");
            }
        }
    }
    /** Выполняет команду с помощью removerById
     * @see RemoveById#removerById(long)
     * @see ArgsChecker#argsChecker(int) (int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(1);
        try {
            removerById(Long.parseLong(Invoker.getSplit()[1]));
        } catch (NumberFormatException ex) {
            throw new NullPointerException();
        }
    }
    @Override
    public String description() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}