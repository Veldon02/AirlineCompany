package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.SafeScanner;
import AirplaneManagement.Program.TableElements;

import java.util.Scanner;

public class FindByFuelConsumptionRange implements ICommand{
    @Override
    public void execute() {
        System.out.println("Enter the lower limit");
        int num1 = SafeScanner.scanInt(1);
        System.out.println("Enter the upper limit");
        int num2 = SafeScanner.scanInt(num1);
        var res = AirlineCompany.getInstance().findByFuelConsumptionRange(num1,num2);
        if (res == null){
            System.out.println("There are no such airplanes\n");
            return;
        }
        TableElements.drawHeader();
        for (var plane: res) {
            TableElements.drawSplitter();
            System.out.println(plane);
        }
        TableElements.drawSplitter();
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "finds airplane by fuel consumption range";
    }
}
