package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Airplane.AirplaneRepository;
import AirplaneManagement.Program.SafeScanner;

import java.util.Scanner;

public class SendForRepairCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        airlineCompany.sendAirplaneForRepair(id);
        System.out.println("you sent airplane on repair");
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "changes \"underRepair\" status of airplane for true";
    }
}
