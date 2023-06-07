package src.vehicleData;

import src.database.UserAuthentication;
import src.database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * The type Vehicle.
 */
public class Vehicle implements Comparable<Vehicle> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private long capacity; //Значение поля должно быть больше 0
    private long fuelConsumption; //Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null
    private final String creator;

    /**
     * Instantiates a new Vehicle.
     *
     * @param name            the name
     * @param coordinates     the coordinates
     * @param enginePower     the engine power
     * @param capacity        the capacity
     * @param fuelConsumption the fuel consumption
     * @param type            the type
     */
    public Vehicle (String name, Coordinates coordinates, Double enginePower, long capacity, long fuelConsumption, VehicleType type){
        setId();
        creationDate = new Date();
        this.name = name;
        this.coordinates = coordinates;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.type = type;
        creator = UserAuthentication.getCurrentUser();
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param id              the id
     * @param name            the name
     * @param coordinates     the coordinates
     * @param creationDate    the creation date
     * @param enginePower     the engine power
     * @param capacity        the capacity
     * @param fuelConsumption the fuel consumption
     * @param type            the type
     * @param creator         the creator
     */
    public Vehicle(long id, String name, Coordinates coordinates, Date creationDate, Double enginePower, long capacity, long fuelConsumption, VehicleType type, String creator) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.type = type;
        this.creator = creator;
    }
    private void setId() {
        long newId = 0;
        ResultSet resultSet = DatabaseConnection.executePreparedStatement("SELECT nextval(?)", "id");
        try {
            resultSet.next();
            newId = resultSet.getLong(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        id = newId;
    }

    /**
     * Get id long.
     *
     * @return the long
     */
    public long getId(){
        return id;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Get coordinates coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }

    /**
     * Get engine power double.
     *
     * @return the double
     */
    public Double getEnginePower(){
        return enginePower;
    }

    /**
     * Get capacity long.
     *
     * @return the long
     */
    public long getCapacity(){
        return capacity;
    }

    /**
     * Get fuel consumption long.
     *
     * @return the long
     */
    public long getFuelConsumption(){
        return fuelConsumption;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public VehicleType getType() {return type;}

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public long getCreationDate() {
        return creationDate.getTime();
    }

    /**
     * Gets creator.
     *
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }
    @Override
    public String toString() {
        return "Транспортное средство " + id + "\n" +
                "Название: " + name + "\n" +
                "Координаты: (" + coordinates.getX() + "; " + coordinates.getY() + ")\n" +
                "Дата и время создания: " + creationDate + "\n" +
                "Мощность двигателя: " + enginePower + "\n" +
                "Вместимость: " + capacity + "\n" +
                "Расход топлива: " + fuelConsumption + "\n" +
                "Тип транспортного средства: " + type + "\n" +
                "Создатель: " + creator + "\n";

    }
    public int compareTo(Vehicle vehicle) {
        return (int)Math.signum(this.enginePower - vehicle.getEnginePower());
    }

}
