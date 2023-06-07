package src.vehicleData;

/**
 * The enum Vehicle type.
 */
public enum VehicleType {
    /**
     * Plane vehicle type.
     */
    PLANE("PLANE","1",1),
    /**
     * Helicopter vehicle type.
     */
    HELICOPTER("HELICOPTER","2",10),
    /**
     * Submarine vehicle type.
     */
    SUBMARINE("SUBMARINE","3",100);
    private final String name;
    private final String number;
    private final int power;
    VehicleType(String name, String number, int power) {
        this.name = name;
        this.number = number;
        this.power = power;
    }

    /**
     * Gets type.
     *
     * @param string the string
     * @return the type
     */
    public static VehicleType getType(String string) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.number.equals(string)|vehicleType.name.equals(string)) return vehicleType;
        }
        return null;
    }

    /**
     * Gets power.
     *
     * @param vehicleType the vehicle type
     * @return the power
     */
    public static int getPower(VehicleType vehicleType) {
        return vehicleType.power;
    }
}
