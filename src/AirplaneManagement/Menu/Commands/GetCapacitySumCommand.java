package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class GetCapacitySumCommand implements ICommand{
    @Override
    public void execute() {
        System.out.printf("Total capacity of all airplanes: %d\n\n",
                AirlineCompany.getInstance().getCapacitySum());
    }

    @Override
    public String getInformation() {
        return "shows the sum of capacity of all airplanes";
    }
}
