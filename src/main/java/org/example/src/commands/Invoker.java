package src.commands;

import src.commands.AllCommands.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The type Invoker.
 */
public class Invoker {
    private static boolean programRunning = true;
    private static String[] split;
    private static final HashMap<String, Command> commandHashMap = new HashMap<>();
    static {
        commandHashMap.put("help", new Help());
        commandHashMap.put("info", new Info());
        commandHashMap.put("show", new Show());
        commandHashMap.put("add", new Add());
        commandHashMap.put("update", new Update());
        commandHashMap.put("remove_by_id", new RemoveById());
        commandHashMap.put("clear", new Clear());
        commandHashMap.put("execute_script", new ExecuteScript());
        commandHashMap.put("exit", new Exit());
        commandHashMap.put("count_greater_than_type", new CountGreaterThanType());
        commandHashMap.put("min_by_capacity", new MinByCapacity());
        commandHashMap.put("remove_last", new MaxByFuelConsumption());
        commandHashMap.put("remove_all_by_type", new RemoveAllByType());
        commandHashMap.put("insert_at", new InsertAtIndex());
    }

    /**
     * Get split string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getSplit() {
        return split;
    }

    /**
     * Sets split.
     *
     * @param split the split
     */
    public static void setSplit(String[] split) {
        Invoker.split = split;
    }

    /**
     * Sets program running.
     *
     * @param programRunning the program running
     */
    public static void setProgramRunning(boolean programRunning) {
        Invoker.programRunning = programRunning;
    }

    /**
     * Gets command hash map.
     *
     * @return the command hash map
     */
    public static HashMap<String, Command> getCommandHashMap() {
        return commandHashMap;
    }

    /**
     * Invoker.
     */
    public static void invoker() {
        System.out.println("Введите команду (help : вывести справку по доступным командам)");
        Scanner scanner = new Scanner(System.in);
        while (programRunning) {
            try {
                split = scanner.nextLine().trim().split(" ");
                commandHashMap.get(split[0]).execute();
            } catch (NullPointerException nullPointerException) {
                if (programRunning) { System.out.println("Неверная команда"); }
            }
        }
        scanner.close();
    }
}
