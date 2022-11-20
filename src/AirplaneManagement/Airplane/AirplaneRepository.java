package AirplaneManagement.Airplane;

import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirplaneRepository {
    private Statement statement;

    public AirplaneRepository(){
        try {
            String dbURL = "jdbc:mysql://localhost:3306/AirlineCompany";
            String user = "root";
            String password = "Qwerty!1";

            Connection connection;
            connection = DriverManager.getConnection(dbURL, user, password);
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.INFO,"DB was connected successfully");
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE,e.getMessage());
            System.out.println("Failed to connect the database");
            System.exit(-1);
        }
    }

//region Get
    public ArrayList<Airplane> getAll(){
        try {
            ArrayList<Airplane> res = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("call GetAllAirplanes();");
            while(resultSet.next()){
                res.add(parseAirplane(resultSet));
            }
            Logger.getGlobal().log(Level.INFO,"successfully read all airplanes from the DB");
            return res;
        }catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public Airplane getAirplane(int id){
        try{
            ResultSet resultSet = statement.executeQuery("call GetAirplane("+id+");");
            if (!resultSet.next()) throw new Exception("There is no airplane with id:"+id);
            return parseAirplane(resultSet);
        }catch (Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getIDs(){
        try {
            ResultSet resultSet = statement.executeQuery("select airplaneid from airplane\norder by airplaneid");
            ArrayList<Integer> res = new ArrayList<>();
            while (resultSet.next())
                res.add(resultSet.getInt("AirplaneID"));
            Logger.getGlobal().log(Level.INFO,"successfully read all airplanes` id from the DB");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }

    }

    public ArrayList<Integer> getCargo(){
        try {
            ResultSet resultSet =  statement.executeQuery("select airplaneid from airplane\nwhere typeid = 2;");
            ArrayList<Integer> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(resultSet.getInt(1));
            }
            Logger.getGlobal().log(Level.INFO,"successfully read all cargo airplanes from the DB");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getPassenger(){
        try {
            ResultSet resultSet =  statement.executeQuery("select airplaneid from airplane\nwhere typeid = 1;");
            ArrayList<Integer> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(resultSet.getInt(1));
            }
            Logger.getGlobal().log(Level.INFO,"successfully read all passenger airplanes from the DB");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getWorking(){
        try {
            ResultSet resultSet =  statement.executeQuery("select airplaneid from airplane\nwhere UnderRepair = False");
            ArrayList<Integer> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(resultSet.getInt(1));
            }
            Logger.getGlobal().log(Level.INFO,"successfully read all passenger airplanes from the DB");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getUnderRepair(){
        try {
            ResultSet resultSet =  statement.executeQuery("select airplaneid from airplane\nwhere UnderRepair = True");
            ArrayList<Integer> res = new ArrayList<>();
            while(resultSet.next()){
                res.add(resultSet.getInt(1));
            }
            Logger.getGlobal().log(Level.INFO,"successfully read all passenger airplanes from the DB");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }
//endregion

//region Adding/Deleting
    public int addAirplane(Airplane airplane){
        try{
            var query = String.format("call InsertAirplane(\"%s\",\"%s\",%s,%d,%d,%d,%d);", airplane.getName(),
                    airplane.getType(),airplane.isUnderRepair(),airplane.getFuelConsumption(),
                    airplane.getCarryingCapacity(), airplane.getPassengerSeatsNumber(),airplane.getMaxFlightRange());
            statement.executeQuery(query);
            ResultSet resultSet = statement.executeQuery("select MAX(airplaneid) from airplane");
            resultSet.next();
            int id = resultSet.getInt(1);
            Logger.getGlobal().log(Level.INFO,"successfully added airplane with id:"+id+" to the DB");
            return id;
        }catch (Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return -1;
        }
    }

    public boolean deleteAirplane(int id){
        try {
            statement.executeQuery("call DeleteAirplaneWithID(" + id + ");");
            Logger.getGlobal().log(Level.INFO,"successfully removed airplane with id:"+id+" from the DB");
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return false;
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
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }

    }
//endregion


//region Sort/Find
    public ArrayList<Integer> sortByFlightRange(){
        try {
            ArrayList<Integer> res = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select airplaneid from airplane\norder by maxFlightRange desc");
            while(resultSet.next()){
                res.add(resultSet.getInt(1));
            }
            Logger.getGlobal().log(Level.INFO,"successfully got sorted airplanes from DB");
            return res;
        }catch (Exception e) {
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> findByFuelConsumptionRange(int num1,int num2){
        try {
            ResultSet resultSet =  statement.executeQuery("call FindByFuelConsumptionRange("+num1+","+num2+");");
            if (!resultSet.next()) return null;
            ArrayList<Integer> res = new ArrayList<>();
            do{
                res.add(resultSet.getInt(1));
            }
            while(resultSet.next());
            Logger.getGlobal().log(Level.INFO,"successfully find airplane by fuel consumption");
            return res;
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }

//endregion

//region Sums
    public Integer getCapacitySum(){
        try{
            ResultSet resultSet = statement.executeQuery("select sum(passengerseatsnumber) from airlinecompany.airplane;");
            resultSet.next();
            Logger.getGlobal().log(Level.INFO,"successfully got total passenger seat number from DB");
            return resultSet.getInt(1);
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }

    }

    public Integer getCarryingCapacitySum(){
        try{
            ResultSet resultSet = statement.executeQuery("select sum(CarryingCapacity) from airplane;");
            resultSet.next();
            Logger.getGlobal().log(Level.INFO,"successfully got total carrying capacity from DB");
            return  resultSet.getInt(1);
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
            return null;
        }
    }
//endregion

//region Change

    public void changeInt(int id,String column, int newValue ){
        try{
            statement.executeUpdate(String.format("update airplane\nset %s=%d\nwhere airplaneid = %d",column,newValue,id));
            Logger.getGlobal().log(Level.INFO,"successfully changed "+column+" column");
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
        }
    }

    public void changeString(int id,String column, String newValue, boolean needBrackets){
        try{
            String value;
            if (needBrackets)
                value = "'"+newValue+"'";
            else
                value = newValue;
            statement.executeUpdate(String.format("update airplane\nset %s=%s\nwhere airplaneid = %d",column,value,id));
            Logger.getGlobal().log(Level.INFO,"successfully changed "+column+" column");
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING,e.getMessage());
        }
    }

//endregion
}
