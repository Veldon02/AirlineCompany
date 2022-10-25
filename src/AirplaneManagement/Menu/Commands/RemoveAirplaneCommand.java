package AirplaneManagement.Menu.Commands;

public class RemoveAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("you removed airplane");
    }

    @Override
    public String getInformation() {
        return "removes airplane from database";
    }
}
