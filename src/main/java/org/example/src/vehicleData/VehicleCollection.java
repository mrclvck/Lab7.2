package src.vehicleData;

import src.database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * The type Vehicle collection.
 */
public class VehicleCollection {
    private static final Stack<Vehicle> vehicles = new Stack<>();
    private static final Date dateOfInitialization = new Date();

    /**
     * Gets vehicle.
     *
     * @return the vehicle
     */
    public static Stack<Vehicle> getVehicle() {
        return vehicles;
    }

    /**
     * Gets info.
     */
    public static void getInfo() {
        System.out.println("Тип коллекции: " + vehicles.getClass().getTypeName().split(".util.")[1] + "\n" +
                "Дата инициализации: " + dateOfInitialization + "\n" +
                "Количество элементов: " + vehicles.size() + "\n");
    }

    /**
     * Put vehicles from db.
     */
    public static void putVehiclesFromDB() {
        try {
            ResultSet resultSet = DatabaseConnection.executePreparedStatement("select * from vehicle");
            while (resultSet.next()) {
                try {
                    vehicles.add(new Vehicle(
                                    resultSet.getLong(1),
                                    resultSet.getString(4),
                                    new Coordinates(resultSet.getDouble(9), resultSet.getLong(10)),
                                    new Date(resultSet.getLong(3)),
                                    resultSet.getDouble(5),
                                    resultSet.getLong(7),
                                    resultSet.getLong(8),
                                    VehicleType.getType(resultSet.getString(6)),
                                    resultSet.getString(2)));
                } catch (Exception ignored) {}
            }
        } catch (SQLException ignored) {}
    }

    /**
     * Update from db.
     */
    public static void updateFromDB() {
        vehicles.clear();
        putVehiclesFromDB();
    }
}
