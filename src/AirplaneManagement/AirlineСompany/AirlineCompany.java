package AirplaneManagement.AirlineСompany;

import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Airplane.AirplaneRepository;
import AirplaneManagement.Menu.Commands.ExitCommand;
import AirplaneManagement.Menu.Commands.HelpCommand;
import AirplaneManagement.Menu.Menu;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AirlineCompany {
    private static AirlineCompany instance;
    private String companyName;
    private final AirplaneRepository airplaneRepository;

    public String getCompanyName(){
        return companyName;
    }

    public ArrayList<Airplane> getAirplanes(){
        return airplaneRepository.getAll();
    }

    private AirlineCompany() {
        airplaneRepository = new AirplaneRepository();
    }

    public static AirlineCompany getInstance() {
        if (instance == null)
            instance = new AirlineCompany();
        return instance;
    }

    public void addAirplane(Airplane airplane){
        airplaneRepository.addAirplane(airplane);
    }

    public void deleteAirplane(int id){
        airplaneRepository.deleteAirplane(id);
    }

}
