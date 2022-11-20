package AirplaneManagement.Menu.Commands;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeCommand implements ICommand{
    @Override
    public void execute() {

        try{
            Stage showStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ChangeScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            showStage.setScene(scene);
            showStage.setTitle("Change");
            showStage.show();
            Logger.getGlobal().log(Level.INFO, "scene loaded successfully");
        }catch(Exception e){
            Logger.getGlobal().log(Level.WARNING, "failed to load scene");
        }
    }

    @Override
    public String getInformation() {
        return "changes type of airplane";
    }
}
