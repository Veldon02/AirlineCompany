package AirplaneManagement.Menu.Commands;

public class ShowCargoCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("cargo planes");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all cargo airplanes";
    }
}
