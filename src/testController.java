import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CountyCheck.Louisiana.Livingston.countyCheck("test.xlsx", "testresults.xlsx", "test");
    }

    public void test(){
        //CountyCheck.Illinois.Adams.countyCheck("test.xlsx", "testresults.xlsx", "QUINCY");
    }
}
