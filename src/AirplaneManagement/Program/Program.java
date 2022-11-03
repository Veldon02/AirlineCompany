package AirplaneManagement.Program;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Menu;

public class Program {
    public static void main(String[] args) {
        var airlineCompany = AirlineCompany.getInstance();
        var menu = Menu.getInstance();
        String command;
        System.out.println("Type help for all available commands");
        while (true) {
            command = SafeScanner.scanString();
            menu.execute(command);
        }
    }
}
