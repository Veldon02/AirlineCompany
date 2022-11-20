package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
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

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveAirplaneSceneController{

    @FXML
    private Label errorLabel;

    @FXML
    private TextField textField;
    @FXML
    private Button btn;


    @FXML public void handleMouseClick(MouseEvent click) {
        var text = textField.getText();
        try{
            int id = Integer.parseInt(text);
            if (!AirlineCompany.getInstance().getIDs().contains(id))
                throw new Exception();
            if (AirlineCompany.getInstance().deleteAirplane(id)){
                errorLabel.setTextFill(Paint.valueOf("Black"));
                errorLabel.setText("Airplane removed");
                Logger.getGlobal().log(Level.INFO, "airplane with id "+id+" removed");
            }else{
                errorLabel.setTextFill(Paint.valueOf("Red"));
                errorLabel.setText("Failed to remove airplane");
                Logger.getGlobal().log(Level.WARNING, "Failed to remove airplane with id:" + id);
            }

        }catch (Exception e){
            errorLabel.setTextFill(Paint.valueOf("Red"));
            errorLabel.setText("There is no plane with such ID");
            Logger.getGlobal().log(Level.WARNING, "There is no plane with such ID:" + text);
        }

    }
}
