package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.awt.datatransfer.FlavorEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetStatisticsSceneController implements Initializable{

    @FXML
    private Label capacityLabel;

    @FXML
    private Label carryingCapacityLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        capacityLabel.setText("The sum of capacity of all airplanes: "+ AirlineCompany.getInstance().getCapacitySum());
        carryingCapacityLabel.setText("The sum of carrying capacity of all airplanes: "+ AirlineCompany.getInstance().getCarryingCapacitySum());
        Logger.getGlobal().log(Level.INFO, "got statistics successfully");
    }

}
