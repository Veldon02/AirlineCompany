package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class ShowCommand implements ICommand{

    @Override
    public void execute() {
        for (var plane: AirlineCompany.getInstance().getAirplanes()) {
            System.out.println(plane);
        }
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all airplanes";
    }
}
