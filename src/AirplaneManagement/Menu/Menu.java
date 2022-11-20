package AirplaneManagement.Menu;

import AirplaneManagement.Menu.Commands.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Menu {
    private static Menu instance;
    private final Map<String, ICommand> commands;

    public Map<String, ICommand> getCommands() {
        return commands;
    }

    private Menu() {
        commands = new LinkedHashMap<>();
        initializeCommands();
    }

    public static Menu getInstance() {
        if (instance == null)
            instance = new Menu();
        return instance;
    }

    public void execute(String command){
        try{
            var cnd = commands.get(command);
            Logger.getGlobal().log(Level.INFO,"command "+command+" was selected");
            cnd.execute();
        }catch (Exception e){
            Logger.getGlobal().log(Level.WARNING,"There is not such command: "+command);
        }
    }
    private void initializeCommands(){
        commands.put("Show", new ShowCommand());
        commands.put("Show by technical status", new ShowByTechnicalStatusCommand());
        commands.put("Show by type", new ShowByTypeCommand());
        commands.put("Add airplane", new AddAirplaneCommand());
        commands.put("Remove airplane", new RemoveAirplaneCommand());
        commands.put("Change", new ChangeCommand());
        commands.put("Find by fuel consumption range", new FindByFuelConsumptionRange());
        commands.put("Get statistics", new GetStatisticsCommand());
        commands.put("Exit", new ExitCommand());
    }

    public ArrayList<String> getShowCommands(){
        ArrayList<String> res = new ArrayList<>();
        for (var cmn: commands.keySet()) {
            if (cmn.contains("show"))
                res.add(cmn);
        }
        return res;
    }
}
