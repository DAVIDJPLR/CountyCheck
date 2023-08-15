import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;

public class test extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("test");
        CountyCheck.problem("HMMM");
        System.out.println("test");
    }
}
