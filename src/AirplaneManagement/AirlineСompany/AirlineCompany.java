package AirplaneManagement.AirlineСompany;

import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Menu.Commands.ExitCommand;
import AirplaneManagement.Menu.Commands.HelpCommand;
import AirplaneManagement.Menu.Menu;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AirlineCompany {
    private static AirlineCompany instance;
    private String companyName;
    private final List<Airplane> airplanes;
    private AirlineCompany() {
        airplanes = new ArrayList<>();
    }

    public List<Airplane> getAirplanes(){
        return airplanes;
    }

    public String getCompanyName(){
        return companyName;
    }

    private AirlineCompany(String name) {
        airplanes = new ArrayList<>();
        companyName = name;
    }

    public static AirlineCompany getInstance() {
        if (instance == null)
            instance = new AirlineCompany();
        return instance;
    }

    public void addAirplane(){
        airplanes.add(new Airplane());
    }
}
