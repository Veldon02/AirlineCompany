package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RemoveAirplaneCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter ID of airplane:");
        Scanner scanner = new Scanner(System.in);
        AirlineCompany.getInstance().deleteAirplane(scanner.nextInt());
        System.out.println("you removed airplane");
    }

    @Override
    public String getInformation() {
        return "removes airplane from database";
    }
}
