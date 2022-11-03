package AirplaneManagement.Airplane;

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
            ResultSet resultSet = statement.executeQuery("call GetAllAirplanes;");
            Airplane airplane;
            while(resultSet.next()){
                var name = resultSet.getString("Name");
                var type = resultSet.getString("Type");
                airplane = new Airplane.AirplaneBuilder(name,type)
                        .setID(resultSet.getInt("AirplaneID"))
                        .setCarryingCapacity(resultSet.getInt("CarryingCapacity"))
                        .setFuelConsumption(resultSet.getInt("FuelConsumption"))
                        .setUnderRepair(resultSet.getBoolean("UnderRepair"))
                        .setPassengerSeatsNumber(resultSet.getInt("PassengerSeatsNumber"))
                        .setMaxFlightRange(resultSet.getInt("MaxFlightRange"))
                        .build();
                res.add(airplane);
            }
            return res;
        }catch (Exception e) {
            System.out.println("oops");
            return null;
        }
    }

    public boolean addAirplane(Airplane airplane){
        StringBuilder query = new StringBuilder("insert into airplane(Name,TypeID,UnderRepair,FuelConsumption,CarryingCapacity,PassengerSeatsNumber,MaxFlightRange)\nvalues(");
        query.append('"');
        query.append(airplane.getName());
        query.append('"');
        query.append(',');
        if (airplane.getType().equals("Пасажирський"))
            query.append(1);
        else
            query.append(2);
        query.append(',');
        query.append(airplane.isUnderRepair());
        query.append(',');
        query.append(airplane.getFuelConsumption());
        query.append(',');
        query.append(airplane.getCarryingCapacity());
        query.append(',');
        query.append(airplane.getPassengerSeatsNumber());
        query.append(',');
        query.append(airplane.getMaxFlightRange());
        query.append(");");
        try{
            statement.executeUpdate(query.toString());
            return true;
        }catch (Exception e){
            System.out.println("не пішло");
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


    public void update(){
        try {
            statement.executeUpdate("update airplanetype\n" +
                    "set name = \"тест\"\n" +
                    "where typeid = 2;");
        }catch (Exception e){
            System.out.println("апдейт похерився");
        }
    }

}
