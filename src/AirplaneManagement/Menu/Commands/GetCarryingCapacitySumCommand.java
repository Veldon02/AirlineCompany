package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class GetCarryingCapacitySumCommand implements ICommand{
    @Override
    public void execute() {
        System.out.printf("Total carrying capacity of all airplanes: %d\n\n",
                AirlineCompany.getInstance().getCarryingCapacitySum());
    }

    @Override
    public String getInformation() {
        return "shows the sum of carrying capacity of all airplanes";
    }
}
