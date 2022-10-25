package AirplaneManagement.Menu;

import AirplaneManagement.Menu.Commands.*;

import java.util.*;

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
            commands.get(command).execute();
        }catch (Exception e){
            System.out.println("Invalid command!");
        }
    }
    private void initializeCommands(){
        commands.put("help", new HelpCommand());
        commands.put("show", new ShowCommand());
        commands.put("show working", new ShowWorkingCommand());
        commands.put("show under repair", new ShowUnderRepairCommand());
        commands.put("show cargo", new ShowCargoCommand());
        commands.put("show passenger", new ShowPassengerCommand());
        commands.put("show private", new ShowPrivateCommand());
        commands.put("add airplane", new AddAirplaneCommand());
        commands.put("remove airplane", new RemoveAirplaneCommand());
        commands.put("change flight", new ChangeFlightCommand());
        commands.put("send for repair", new SendForRepairCommand());
        commands.put("pick up from repair", new PickUpFromRepairCommand());
        commands.put("sort by flight range", new SortByFlightRangeCommand());
        commands.put("find by fuel consumption range", new FindByFuelConsumptionRange());
        commands.put("exit", new ExitCommand());

    }
}
