package AirplaneManagement.Airplane;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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


}
