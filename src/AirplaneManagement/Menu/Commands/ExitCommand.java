package AirplaneManagement.Menu.Commands;

public class ExitCommand implements ICommand{

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getInformation() {
        return "ends program";
    }
}
