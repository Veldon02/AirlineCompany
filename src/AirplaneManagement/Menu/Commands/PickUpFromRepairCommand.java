package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

import java.util.Scanner;

public class PickUpFromRepairCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        airlineCompany.pickUpFromRepair(id);
        System.out.println("you picked up airplane from repair");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes \"underRepair\" status of airplane for false";
    }
}
