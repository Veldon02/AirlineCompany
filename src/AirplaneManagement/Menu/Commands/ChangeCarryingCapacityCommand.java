package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

public class ChangeCarryingCapacityCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        System.out.println("Enter carrying capacity:");
        var carryingCapacity = SafeScanner.scanInt(1);
        airlineCompany.changeCarryingCapacity(id, carryingCapacity);
        System.out.println("you have changed the carrying capacity");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes carrying capacity of airplane";
    }
}
