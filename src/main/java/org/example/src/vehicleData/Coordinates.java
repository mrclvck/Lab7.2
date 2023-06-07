package src.vehicleData;

/**
 * The type Coordinates.
 */
public class Coordinates {

    private double x;
    private long y; //Максимальное значение поля: 746

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public long getY() {
        return y;
    }

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

}
