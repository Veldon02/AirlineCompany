package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RemoveAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID of airplane:");
        var airlineCompany = AirlineCompany.getInstance();
        int id = SafeScanner.scanInt(airlineCompany.getIDs());
        airlineCompany.deleteAirplane(id);
        System.out.println("you removed airplane");
    }

    @Override
    public String getInformation() {
        return "removes airplane from database";
    }
}
