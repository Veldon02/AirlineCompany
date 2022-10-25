package AirplaneManagement.Menu.Commands;

public class FindByFuelConsumptionRange implements ICommand{
    @Override
    public void execute() {
        System.out.println("find airplane by fuel consumption range");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "finds airplane by fuel consumption range";
    }
}
