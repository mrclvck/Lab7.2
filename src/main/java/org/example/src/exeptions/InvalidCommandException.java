package src.exeptions;

/**
 * The type Invalid command exception.
 */
public class InvalidCommandException extends Exception{
    /**
     * Instantiates a new Invalid command exception.
     */
    public InvalidCommandException() {
        super("Неверная команда");
    }
}