package src.commands.AllCommands;

import src.vehicleData.VehicleCollection;
import src.commands.Command;
import src.commands.ArgsChecker;
import src.database.DatabaseConnection;
import src.database.UserAuthentication;

public class Clear implements Command {
    /**Метод, очищающий коллекцию
     */
    @Override
    public void execute() {
        ArgsChecker.argsChecker(0);
        DatabaseConnection.executeStatement("delete from vehicle where creator = '" + UserAuthentication.getCurrentUser() + "'");
        VehicleCollection.updateFromDB();
        System.out.println("Созданная Вами часть коллекции очищена");
    }
    @Override
    public String description() {
        return "clear : очистить коллекцию";
    }
}