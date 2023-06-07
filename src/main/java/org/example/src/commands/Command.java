package src.commands;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute.
     */
    void execute();

    /**
     * Description string.
     *
     * @return the string
     */
    String description();

}