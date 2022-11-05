package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

public class ChangePassengerSeatsNumberCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        System.out.println("Enter passenger seats number:");
        var passengerSeatsNumber = SafeScanner.scanInt(1,65536);
        airlineCompany.changePassengerSeatsNumberCommand(id, passengerSeatsNumber);
        System.out.println("you have changed the passenger seats number");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes passenger seats number of airplane";
    }
}
