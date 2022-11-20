package AirplaneManagement.AirlineСompany;

import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Airplane.AirplaneRepository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirlineCompany {
    private static AirlineCompany instance;
    private String companyName;
    private final AirplaneRepository airplaneRepository;
    public void setCompanyName(String name){
        companyName = name;
    }

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
    public Airplane getAirplane(int id){
        return airplaneRepository.getAirplane(id);
    }

    public int addAirplane(Airplane airplane){
        return airplaneRepository.addAirplane(airplane);
    }

    public boolean deleteAirplane(int id){
        return airplaneRepository.deleteAirplane(id);
    }

    public ArrayList<Integer> getIDs(){
        return airplaneRepository.getIDs();
    }

    public ArrayList<Integer> sortByFlightRange(){
        return airplaneRepository.sortByFlightRange();
    }

    public ArrayList<Integer> findByFuelConsumptionRange(int num1, int num2){
        return airplaneRepository.findByFuelConsumptionRange(num1, num2);
    }

    public Integer getCarryingCapacitySum(){
        return airplaneRepository.getCarryingCapacitySum();
    }

    public Integer getCapacitySum(){
        return airplaneRepository.getCapacitySum();
    }

    public ArrayList<Integer> getCargo(){
        return airplaneRepository.getCargo();
    }
    public ArrayList<Integer> getPassenger(){
        return airplaneRepository.getPassenger();
    }
    public ArrayList<Integer> getWorking(){
        return airplaneRepository.getWorking();
    }

    public ArrayList<Integer> getUnderRepair(){
        return airplaneRepository.getUnderRepair();
    }

    public void changeInt(int id,String column, int newValue ){
        airplaneRepository.changeInt(id,column,newValue);
    }

    public void changeString(int id,String column, String newValue, boolean needBrackets ){
        airplaneRepository.changeString(id,column,newValue,needBrackets);
    }
}
