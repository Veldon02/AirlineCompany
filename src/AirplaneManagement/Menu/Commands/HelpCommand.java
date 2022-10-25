package AirplaneManagement.Menu.Commands;

import AirplaneManagement.Menu.Menu;
import java.util.*;

public class HelpCommand implements ICommand{

    @Override
    public void execute() {
        var commands = (LinkedHashMap)Menu.getInstance().getCommands();
        for (var command: commands.keySet()) {
            System.out.println(command + " - " + ((ICommand)commands.get(command)).getInformation());
        }
        System.out.println();

    }

    @Override
    public String getInformation() {
        return "shows all available commands";
    }
}
