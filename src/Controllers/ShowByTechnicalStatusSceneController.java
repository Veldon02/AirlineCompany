package Controllers;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import com.mysql.cj.exceptions.StreamingNotifiable;
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

public class ShowByTechnicalStatusSceneController implements Initializable{

    @FXML
    private ListView<Integer> listView;

    @FXML
    private Label label;

    @FXML
    private ChoiceBox<String> choiceBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] statuses = {"Working","Under repair"};
        choiceBox.getItems().addAll(statuses);
        choiceBox.setValue("Working");
        choiceBox.setOnAction(this::choiceBoxSelect);
        ObservableList<Integer> list = FXCollections.observableArrayList(AirlineCompany.getInstance().getWorking());
        listView.setItems(list);
        label.setText(AirlineCompany.getInstance().getAirplane(list.get(0)).toString());
    }

    @FXML public void handleMouseClick(MouseEvent click) {
        var id =listView.getSelectionModel().getSelectedItem();
        label.setText(AirlineCompany.getInstance().getAirplane(id).toString());
    }

    public void choiceBoxSelect(ActionEvent actionEvent){
        ObservableList<Integer> list;
        if (choiceBox.getSelectionModel().getSelectedItem().equals("Working"))
            list = FXCollections.observableArrayList(AirlineCompany.getInstance().getWorking());
        else
            list = FXCollections.observableArrayList(AirlineCompany.getInstance().getUnderRepair());
        label.setText(AirlineCompany.getInstance().getAirplane(list.get(0)).toString());
        listView.setItems(list);
        Logger.getGlobal().log(Level.INFO,"Showed " + choiceBox.getSelectionModel().getSelectedItem() + "airplanes");
    }

}
