package AirplaneManagement.Program;

import AirplaneManagement.AirlineСompany.AirlineCompany;
import AirplaneManagement.Menu.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.*;

public class Program extends Application {

    public static void main(String[] args) {
        initializeLogger();
        var airlineCompany = AirlineCompany.getInstance();
        airlineCompany.setCompanyName("Veldon`s Company");
        var menu = Menu.getInstance();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("/FXML/Main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Airplane Management : " + AirlineCompany.getInstance().getCompanyName());
        stage.show();
    }

    private static void initializeLogger(){
        try {
            Logger logger = Logger.getGlobal();
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            FileHandler fileHandler = new FileHandler("./AirplaneManagementLogs.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
            MailHandler mailHandler = new MailHandler("mervasyamer@gmail.com");
            logger.addHandler(mailHandler);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);
            logger.log(Level.INFO,"logger set up successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

}





