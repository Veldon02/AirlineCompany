package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Program.SafeScanner;

import java.util.Scanner;

public class AddAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter name: ");
        var name = SafeScanner.scanString(45);

        System.out.println("Enter type(1 - passenger, 2 - cargo): ");
        var type = (SafeScanner.scanInt(1,2)==1)?"Passenger":"Cargo";

        System.out.println("Is airplane under repair(1 - yes, 2 - no): ");
        var isUnderRepair = SafeScanner.scanInt(1,2) == 1;

        System.out.println("Enter fuel consumption:");
        var fuelConsumption = SafeScanner.scanInt(1,65536);

        System.out.println("Enter carrying capacity:");
        var carryingCapacity = SafeScanner.scanInt(1);

        System.out.println("Enter passenger seats number:");
        var passengerSeatsNumber = SafeScanner.scanInt(1,65536);

        System.out.println("Enter max flight range:");
        var maxFlightRange = SafeScanner.scanInt(1,65536);

        Airplane airplane = new Airplane.AirplaneBuilder(name,type)
                .setUnderRepair(isUnderRepair)
                .setFuelConsumption(fuelConsumption)
                .setCarryingCapacity(carryingCapacity)
                .setPassengerSeatsNumber(passengerSeatsNumber)
                .setMaxFlightRange(maxFlightRange)
                .build();
        if (AirlineCompany.getInstance().addAirplane(airplane))
            System.out.println("Airplane is added");
    }

    @Override
    public String getInformation() {
        return "adds new airplane to database";
    }
}
