package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowSceneController implements Initializable{

    @FXML
    private ListView<Integer> listView;

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> choiceBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] statuses = {"All","Sort by flight range"};
        choiceBox.getItems().addAll(statuses);
        choiceBox.setValue("All");
        choiceBox.setOnAction(this::choiceBoxSelect);
        ObservableList<Integer> list = FXCollections.observableArrayList(AirlineCompany.getInstance().getIDs());
        listView.setItems(list);
        label.setText(AirlineCompany.getInstance().getAirplane(list.get(0)).toString());
    }

    @FXML public void handleMouseClick(MouseEvent click) {
        var id =listView.getSelectionModel().getSelectedItem();
        label.setText(AirlineCompany.getInstance().getAirplane(id).toString());
    }

    public void choiceBoxSelect(ActionEvent actionEvent){
        ObservableList<Integer> list;
        if (choiceBox.getSelectionModel().getSelectedItem().equals("All"))
            list = FXCollections.observableArrayList(AirlineCompany.getInstance().getIDs());
        else
            list = FXCollections.observableArrayList(AirlineCompany.getInstance().sortByFlightRange());
        label.setText(AirlineCompany.getInstance().getAirplane(list.get(0)).toString());
        listView.setItems(list);
        Logger.getGlobal().log(Level.INFO,"Showed " + choiceBox.getSelectionModel().getSelectedItem() + "airplanes");
    }

}
