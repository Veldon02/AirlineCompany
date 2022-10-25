package AirplaneManagement.Menu.Commands;

public class SortByFlightRangeCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("sorted airplanes");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "sorts airplanes by flight";
    }
}
