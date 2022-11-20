package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Parent root;

    @FXML
    private ListView<String> listView;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList(Menu.getInstance().getCommands().keySet());
        listView.setItems(list);
    }

    @FXML public void handleMouseClick(MouseEvent click) {
        if (click.getClickCount() == 2)
            Menu.getInstance().execute(listView.getSelectionModel().getSelectedItem());
    }
}
