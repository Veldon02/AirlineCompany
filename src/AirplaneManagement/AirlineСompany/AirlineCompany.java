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



    private AirlineCompany() {
        airplaneRepository = new AirplaneRepository();
    }

    public static AirlineCompany getInstance() {
        if (instance == null)
            instance = new AirlineCompany();
        return instance;
    }

    public ArrayList<Airplane> getAirplanes(){
        return airplaneRepository.getAll();
    }

    public boolean addAirplane(Airplane airplane){
        return airplaneRepository.addAirplane(airplane);
    }

    public void deleteAirplane(int id){
        airplaneRepository.deleteAirplane(id);
    }

    public void sendAirplaneForRepair(int id){
        airplaneRepository.sendAirplaneForRepair(id);
    }

    public void pickUpFromRepair(int id){
        airplaneRepository.pickUpFromRepair(id);
    }

    public ArrayList<Integer> getIDs(){
        return airplaneRepository.getIDs();
    }

    public ArrayList<Airplane> sortByFlightRange(){
        return airplaneRepository.sortByFlightRange();
    }

    public ArrayList<Airplane> findByFuelConsumptionRange(int num1, int num2){
        return airplaneRepository.findByFuelConsumptionRange(num1, num2);
    }

    public Integer getCarryingCapacitySum(){
        return airplaneRepository.getCarryingCapacitySum();
    }

    public Integer getCapacitySum(){
        return airplaneRepository.getCapacitySum();
    }

    public ArrayList<Airplane> getCargo(){
        return airplaneRepository.getCargo();
    }
    public ArrayList<Airplane> getPassenger(){
        return airplaneRepository.getPassenger();
    }

    public void changeType(int id, int newType){
        airplaneRepository.changeType(id, newType);
    }

    public void changeCarryingCapacity(int id, int carryingCapacity){
        airplaneRepository.changeCarryingCapacity(id,carryingCapacity);
    }

    public void changePassengerSeatsNumberCommand(int id, int number){
        airplaneRepository.changePassengerSeatsNumberCommand(id,number);
    }

    public void changeMaxFlightRange(int id, int range){
        airplaneRepository.changeMaxFlightRange(id,range);
    }
}
