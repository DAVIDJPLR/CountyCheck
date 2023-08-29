import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void test(){
        CountyCheck.Illinois.Will.countyCheck("joliet.xlsx", "Will_Joliet_Results.xlsx", "Joliet");
    }
}
