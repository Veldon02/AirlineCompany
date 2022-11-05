package AirplaneManagement.Airplane;

import AirplaneManagement.Menu.Commands.SortByFlightRangeCommand;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

public class AirplaneRepository {
    private Statement statement;
    private Dictionary<Integer,String> dic = new Hashtable<>();

    public AirplaneRepository(){
        try {
            String dbURL = "jdbc:mysql://localhost:3306/AirlineCompany";
            String user = "root";
            String password = "Qwerty!1";

            Connection connection;
            connection = DriverManager.getConnection(dbURL, user, password);
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println("Something went wrong :(");
        }
    }

    public ArrayList<Airplane> getAll(){
        try {
            ArrayList<Airplane> res = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("call GetAllAirplanes();");
            while(resultSet.next()){
                res.add(parseAirplane(resultSet));
            }
            return res;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean addAirplane(Airplane airplane){
        try{
            var query = String.format("call InsertAirplane(\"%s\",\"%s\",%s,%d,%d,%d,%d);", airplane.getName(),
                    airplane.getType(),airplane.isUnderRepair(),airplane.getFuelConsumption(),
                    airplane.getCarryingCapacity(), airplane.getPassengerSeatsNumber(),airplane.getMaxFlightRange());
            statement.executeQuery(query);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void deleteAirplane(int id){
        try {
            statement.executeQuery("call DeleteAirplaneWithID(" + id + ");");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void sendAirplaneForRepair(int id){
        try {
            statement.executeUpdate("call SendAirplaneForRepair(" + id + ");");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void pickUpFromRepair(int id){
        try {
            statement.executeUpdate("call PickUpFromRepair(" + id + ");");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Integer> getIDs(){
        ArrayList<Integer> res = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select airplaneid from airplane");
            while (resultSet.next())
                res.add(resultSet.getInt("AirplaneID"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return res;
    }

    public ArrayList<Airplane> sortByFlightRange(){
        try {
            ArrayList<Airplane> res = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("call GetSortByMaxFlightRange();");
            while(resultSet.next()){
                res.add(parseAirplane(resultSet));
            }
            return res;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Airplane parseAirplane(ResultSet resultSet){
        try {
            var name = resultSet.getString("Name");
            var type = resultSet.getString("Type");
            return new Airplane.AirplaneBuilder(name, type)
                    .setID(resultSet.getInt("AirplaneID"))
                    .setCarryingCapacity(resultSet.getInt("CarryingCapacity"))
                    .setFuelConsumption(resultSet.getInt("FuelConsumption"))
                    .setUnderRepair(resultSet.getBoolean("UnderRepair"))
                    .setPassengerSeatsNumber(resultSet.getInt("PassengerSeatsNumber"))
                    .setMaxFlightRange(resultSet.getInt("MaxFlightRange"))
                    .build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public ArrayList<Airplane> findByFuelConsumptionRange(int num1,int num2){
        try {
            ResultSet resultSet =  statement.executeQuery("call FindByFuelConsumptionRange("+num1+","+num2+");");
            if (!resultSet.next()) return null;
            ArrayList<Airplane> res = new ArrayList<>();
            do{
                res.add(parseAirplane(resultSet));
            }
            while(resultSet.next());

            return res;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getCapacitySum(){
        try{
            ResultSet resultSet = statement.executeQuery("select sum(passengerseatsnumber) from airlinecompany.airplane;");
            resultSet.next();
            return resultSet.getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Integer getCarryingCapacitySum(){
        try{
            ResultSet resultSet = statement.executeQuery("select sum(CarryingCapacity) from airplane;");
            resultSet.next();
            return  resultSet.getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Airplane> getCargo(){
        try {
            ResultSet resultSet =  statement.executeQuery("call GetCargo();");
            ArrayList<Airplane> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(parseAirplane(resultSet));
            }
            return res;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Airplane> getPassenger(){
        try {
            ResultSet resultSet =  statement.executeQuery("call GetPassenger();");
            ArrayList<Airplane> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(parseAirplane(resultSet));
            }
            return res;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void changeType(int id, int newType){
        try{
            statement.executeQuery(String.format("call UpdateType(%d,%d)",id,newType));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changeCarryingCapacity(int id, int carryingCapacity){
        try{
            statement.executeQuery(String.format("call UpdateCarryingCapacity(%d,%d)",id,carryingCapacity));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changePassengerSeatsNumberCommand(int id, int number){
        try{
            statement.executeQuery(String.format("call UpdatePassengerSeatsNumber(%d,%d)",id,number));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changeMaxFlightRange(int id, int range){
        try{
            statement.executeQuery(String.format("call UpdateMaxFlightRange(%d,%d)",id,range));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
