package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

public class ChangeMaxFlightRangeCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        System.out.println("Enter max flight range:");
        var maxFlightRange = SafeScanner.scanInt(1,65536);
        airlineCompany.changeMaxFlightRange(id, maxFlightRange);
        System.out.println("you have changed the max flight range of airplane ");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes max flight range";
    }
}
