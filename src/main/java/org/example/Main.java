import src.commands.Invoker;
import src.database.DatabaseConnection;
import src.database.UserAuthentication;
import src.vehicleData.VehicleCollection;

import java.util.NoSuchElementException;


public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            DatabaseConnection.createTablesIfNotExist();
            UserAuthentication.userAuthentication();
            if (UserAuthentication.getCurrentUser() != null) {
                VehicleCollection.putVehiclesFromDB();
                Invoker.invoker();
            } else {
                System.out.println("Использование программы незарегистрированным пользователям запрещено");
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Неверный ввод, перезапустите программу");
        }
    }
}