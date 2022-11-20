package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeSceneController implements Initializable{


    @FXML
    private TextField IDField;

    @FXML
    private TextField newValueField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button changeBtn;

    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] list = {"Name","Type","UnderRepair","FuelConsumption","CarryingCapacity","PassengerSeatsNumber","MaxFlightRange"};
        choiceBox.getItems().addAll(list);
        choiceBox.setValue("Name");
    }

    @FXML public void handleMouseClick(MouseEvent click) {
        String idtext = IDField.getText();
        String newValuetext = newValueField.getText();
        String characteristic = choiceBox.getSelectionModel().getSelectedItem();
        try{
            if (idtext.equals("")||newValuetext.equals(""))
                throw new Exception();
            int id = Integer.parseInt(idtext);
            if (!AirlineCompany.getInstance().getIDs().contains(id))
                throw new Exception();

            if (characteristic.equals("Type")){
                if (!newValuetext.equals("Passenger") && !newValuetext.equals("Cargo"))
                    throw new Exception();

                AirlineCompany.getInstance().changeInt(id,"TypeID",newValuetext.equals("Passenger")?1:2);
            }
            else if (characteristic.equals("UnderRepair")){
                if (!newValuetext.equals("True") && !newValuetext.equals("False"))
                    throw new Exception();
                AirlineCompany.getInstance().changeString(id,characteristic,newValuetext,false);
            }
            else if (characteristic.equals("Name")){
                AirlineCompany.getInstance().changeString(id,characteristic,newValuetext,true);
            }
            else{
                int value = Integer.parseInt(newValuetext);
                if (value<=0) throw new Exception();
                AirlineCompany.getInstance().changeInt(id,characteristic,value);
            }
            errorLabel.setTextFill(Paint.valueOf("Black"));
            errorLabel.setText("changed");
            Logger.getGlobal().log(Level.INFO,"successfully changed "+characteristic+" of airplane with id: "+idtext);
        }catch(Exception e){
            errorLabel.setTextFill(Paint.valueOf("Red"));
            errorLabel.setText("invalid input!");
            Logger.getGlobal().log(Level.WARNING,"was entered invalid input");
        }
    }
}
