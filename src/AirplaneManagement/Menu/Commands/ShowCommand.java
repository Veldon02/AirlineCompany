package AirplaneManagement.Menu.Commands;

import AirplaneManagement.AirlineСompany.AirlineCompany;

public class ShowCommand implements ICommand{

    @Override
    public void execute() {
        int i = 1;
        for (var plane: AirlineCompany.getInstance().getAirplanes()) {
            System.out.printf("%d) %s\n", i, plane);
            i++;
        }
        System.out.println();
    }

    @Override
    public String getInformation() {
        return "shows all airplanes";
    }
}
