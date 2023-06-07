package src.commands.AllCommands;

import src.commands.Command;
import src.commands.ArgsChecker;
import src.commands.Invoker;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Command {
    /** Поле, отвечающее за работу счетчика повтора выполнения команды execute_script */
    private static int recursionChecker = 0;
    /** Поле, отвечающее за остановку выполнения команды execute_script при достижении 10 её повторов */
    private boolean recursion = false;
    /** Метод, считывающий команды из файла
     * @see ExecuteScript#invokerFromFile(Scanner) */
    private void executorFromFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext() & !recursion) {
            Invoker.setSplit(scanner.nextLine().split(" "));
            try {
                if (recursionChecker < 10) {
                    invokerFromFile(scanner);
                } else {
                    recursionChecker = 0;
                    recursion = true;
                    System.out.println("Рекурсия!!!");
                }
            } catch (NullPointerException ignored) {}
        }
        scanner.close();
    }
    /** Метод, выполняющий команды из файла
     * @see Add#adderFromFile(Scanner)
     * @see Update#updaterFromFile(Scanner)
     * @see Command#execute() */
    private void invokerFromFile(Scanner scanner) {
        switch (Invoker.getSplit()[0]) {
            case "add" -> Add.adderFromFile(scanner);
            case "update" -> Update.updaterFromFile(scanner);
            case "execute_script" -> {
                ++recursionChecker;
                Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
            }
            default -> Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
        }
    }

    /** Метод, проверяющий файл и исполняющий скрипт из файла с помощью executorFromFile
     * * @see ExecuteScript#executorFromFile(String)
     * @see ArgsChecker#argsChecker(int) */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(1);
        String file = Invoker.getSplit()[1];
        try {
            if (new File(file).exists() & new File(file).canRead()) {
                recursion = false;
                executorFromFile(file);
            } else {
                System.out.println("Нет доступа к файлу");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Файл не найден");
        }
    }
    @Override
    public String description() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
    }
}