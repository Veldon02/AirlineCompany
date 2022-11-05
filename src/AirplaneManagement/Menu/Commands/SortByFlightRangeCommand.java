package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Program.TableElements;

public class SortByFlightRangeCommand implements ICommand{
    @Override
    public void execute() {
        TableElements.drawHeader();
        for (var plane: AirlineCompany.getInstance().sortByFlightRange()) {
            TableElements.drawSplitter();
            System.out.println(plane);
        }
        TableElements.drawSplitter();
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "sorts airplanes by flight";
    }
}
