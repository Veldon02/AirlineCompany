package AirplaneManagement.Program;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Commands.ICommand;
import AirplaneManagement.Menu.Menu;

import java.util.Hashtable;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        var airlineCompany = AirlineCompany.getInstance();
        airlineCompany.addAirplane();
        airlineCompany.addAirplane();
        airlineCompany.addAirplane();
        airlineCompany.addAirplane();
        var menu = Menu.getInstance();
        Scanner input = new Scanner(System.in);
        String command;
        System.out.println("Type help for all available commands");
        while (true) {
            command = input.nextLine();
            menu.execute(command);
        }
    }
}
