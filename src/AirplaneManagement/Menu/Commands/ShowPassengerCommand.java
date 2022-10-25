package AirplaneManagement.Menu.Commands;

public class ShowPassengerCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("passengers airplanes");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all passenger airplanes";
    }
}
