package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindByFuelConsumptionRangeSceneController{

    @FXML
    private ListView<Integer> listView;

    @FXML
    private TextField upperLimitField;

    @FXML
    private TextField lowerLimitField;
    @FXML
    private Label label;

    @FXML
    private Label errorLabel;

    @FXML
    private Button findBtn;

    @FXML public void handleMouseClick(MouseEvent click) {
        var id =listView.getSelectionModel().getSelectedItem();
        label.setText(AirlineCompany.getInstance().getAirplane(id).toString());
    }

    public void findMouseClick(MouseEvent click){
        try{
            int lowerLimit = Integer.parseInt(lowerLimitField.getText());
            int upperLimit = Integer.parseInt(upperLimitField.getText());
            var ids = AirlineCompany.getInstance().findByFuelConsumptionRange(lowerLimit,upperLimit);
            if (upperLimit<lowerLimit)
                throw new Exception();
            if (upperLimit<=0 || lowerLimit<=0)
                throw new Exception();
            if (ids == null){
                errorLabel.setTextFill(Paint.valueOf("Black"));
                errorLabel.setText("There are no such airplanes");
                Logger.getGlobal().log(Level.INFO,"There are no such airplanes in ["+lowerLimit+","+upperLimit+"]");
            }else{
                listView.setItems(FXCollections.observableArrayList(ids));
                Logger.getGlobal().log(Level.INFO, "Successfully found airplanes in ["+lowerLimit+","+upperLimit+"]");
            }

        }catch(Exception e){
            errorLabel.setTextFill(Paint.valueOf("Red"));
            errorLabel.setText("invalid input!");
            Logger.getGlobal().log(Level.WARNING,"was entered invalid input");
        }
    }

}
