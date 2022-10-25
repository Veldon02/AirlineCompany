package AirplaneManagement.Menu.Commands;

public class ShowPrivateCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("private planes");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all private airplanes";
    }
}
