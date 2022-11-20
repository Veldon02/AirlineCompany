package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Airplane.Airplane;
import AirplaneManagement.Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddAirplaneSceneController{

    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField underRepairField;
    @FXML
    private TextField fuelConsumptionField;
    @FXML
    private TextField passengerSeatsNumberField;
    @FXML
    private TextField carryingCapacityField;
    @FXML
    private TextField maxFlightRangeField;

    @FXML
    private Button addButton;

    @FXML
    private Label errorLabel;

    @FXML public void handleMouseClick(MouseEvent click) {
        try {
            Airplane airplane;
            String name = nameField.getText();
            if (name.equals("")) throw new Exception();
            String type = typeField.getText();
            if (!type.equals("Passenger") && !type.equals("Cargo"))
                throw new Exception();
            String status = underRepairField.getText();
            if (!status.equals("True") && !status.equals("False"))
                throw new Exception();
            boolean underRepair = status.equals("True");
            int fuelConsumption = Integer.parseInt(fuelConsumptionField.getText());
            if (fuelConsumption<=0) throw new Exception();
            int passengerSeatNumber = Integer.parseInt(passengerSeatsNumberField.getText());
            if (passengerSeatNumber<=0) throw new Exception();
            int carryingCapacity = Integer.parseInt(carryingCapacityField.getText());
            if (carryingCapacity<=0) throw new Exception();
            int maxFlightRange = Integer.parseInt(maxFlightRangeField.getText());
            if (maxFlightRange<=0) throw new Exception();
            airplane = new Airplane.AirplaneBuilder(name,type)
                    .setUnderRepair(underRepair)
                    .setFuelConsumption(fuelConsumption)
                    .setCarryingCapacity(carryingCapacity)
                    .setPassengerSeatsNumber(passengerSeatNumber)
                    .setMaxFlightRange(maxFlightRange)
                    .build();
            int id = AirlineCompany.getInstance().addAirplane(airplane);
            if(id != -1) {
                errorLabel.setTextFill(Paint.valueOf("Black"));
                errorLabel.setText("airplane added with id:"+id);
                Logger.getGlobal().log(Level.INFO,"Airplane added successfully with id:"+id);
            }else{
                errorLabel.setTextFill(Paint.valueOf("Red"));
                errorLabel.setText("failed to add the airplane");
                Logger.getGlobal().log(Level.WARNING,"failed to add the airplane");
            }
        }catch (Exception e){
            errorLabel.setTextFill(Paint.valueOf("Red"));
            errorLabel.setText("invalid input!");
            Logger.getGlobal().log(Level.WARNING,"was entered invalid input");
        }


    }
}
