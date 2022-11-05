package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

public class ChangeTypeCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        System.out.println("Enter type(1 - passenger, 2 - cargo):");
        var newType = SafeScanner.scanInt(1,2);
        airlineCompany.changeType(id, newType);
        System.out.println("you have changed the type");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes type of airplane";
    }
}
