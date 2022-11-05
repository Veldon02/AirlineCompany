package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.TableElements;

public class ShowPassengerCommand implements ICommand{
    @Override
    public void execute() {
        TableElements.drawHeader();
        for (var plane: AirlineCompany.getInstance().getPassenger()) {
            TableElements.drawSplitter();
            System.out.println(plane);

        }
        TableElements.drawSplitter();
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all passenger airplanes";
    }
}
