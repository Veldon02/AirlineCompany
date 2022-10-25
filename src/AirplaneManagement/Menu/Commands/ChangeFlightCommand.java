package AirplaneManagement.Menu.Commands;

public class ChangeFlightCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("you changed airplane`s information");
    }

    @Override
    public String getInformation() {
        return "changes information about airplane";
    }
}
