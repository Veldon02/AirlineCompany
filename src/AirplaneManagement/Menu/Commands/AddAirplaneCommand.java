package AirplaneManagement.Menu.Commands;

public class AddAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("you added airplane");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "adds new airplane to database";
    }
}
