package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Airplane.Airplane;

import java.util.Scanner;

public class AddAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name: ");
        var name = scanner.nextLine();
        System.out.println("Enter type(1 - passenger, 2 - cargo): ");
        String type;
        if (scanner.nextInt() == 1){
            type = "Пасажирський";
        }else
            type = "Вантажний";
        System.out.println("Is airplane under repair(1 - yes, 2 - no): ");
        var isUnderRepair = scanner.nextInt() == 1;
        System.out.println("Enter fuel consumption:");
        var fuelConsumption = scanner.nextInt();
        System.out.println("Enter carrying capacity:");
        var carryingCapacity = scanner.nextInt();
        System.out.println("Enter passenger seats number");
        var passengerSeatsNumber = scanner.nextInt();
        System.out.println("Enter max flight range:");
        var maxFlightRange = scanner.nextInt();
        Airplane airplane = new Airplane.AirplaneBuilder(name,type)
                .setUnderRepair(isUnderRepair)
                .setFuelConsumption(fuelConsumption)
                .setCarryingCapacity(carryingCapacity)
                .setPassengerSeatsNumber(passengerSeatsNumber)
                .setMaxFlightRange(maxFlightRange)
                .build();
        AirlineCompany.getInstance().addAirplane(airplane);
        System.out.println("Airplane is added");
    }

    @Override
    public String getInformation() {
        return "adds new airplane to database";
    }
}
