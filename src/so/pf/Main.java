package so.pf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("Monitores");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnHidden(e -> {
            controller.shutdown();
        });
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
