package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Program.TableElements;

public class ShowUnderRepairCommand implements ICommand{
    @Override
    public void execute() {
        TableElements.drawHeader();
        for (var plane: AirlineCompany.getInstance().getAirplanes()) {
            if (plane.isUnderRepair()) {
                TableElements.drawSplitter();
                System.out.println(plane);
            }
        }
        TableElements.drawSplitter();
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all airplanes that are underRepair";
    }
}
