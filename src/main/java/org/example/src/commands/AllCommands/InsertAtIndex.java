package src.commands.AllCommands;

import src.commands.ArgsChecker;
import src.vehicleData.Adder;
import src.commands.Command;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The type Insert at index.
 */
public class InsertAtIndex implements Command {
@Override
public void execute() {
        ArgsChecker.argsChecker(0);
        Adder.vehicleAdderToDB(Adder.vehicleAdder());
        }

        /**
         * Adder from file.
         *
         * @param scanner the scanner
         */
        protected static void adderFromFile(Scanner scanner) {
        try {
        Adder.vehicleAdderToDB(Adder.fromFileAdder(scanner));
        } catch (InputMismatchException ignored) {}}

@Override
public String description() {
        return "insert_at index {element} : добавить новый элемент в заданную позицию";
        }
}
