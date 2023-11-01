import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CountyCheck.Illinois.Adams.countyCheck("QUINCY.xlsx", "QUINCY_RESULTS.xlsx", "QUINCY");

    }

    public void test(){
        //CountyCheck.Illinois.Adams.countyCheck("test.xlsx", "testresults.xlsx", "QUINCY");
    }
}
