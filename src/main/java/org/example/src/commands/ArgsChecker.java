package src.commands;

/**
 * The type Args checker.
 */
public class ArgsChecker {
    /**
     * Args checker.
     *
     * @param amountOfArgs the amount of args
     */
    public static void argsChecker(int amountOfArgs) {
        if (Invoker.getSplit().length - 1 != amountOfArgs) {
            throw new NullPointerException();
        }
    }
}
