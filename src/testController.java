import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CountyCheck.Texas.Smith.countyCheck("test.xlsx", "test_results.xlsx", "Whitehouse");
        CountyCheck.Illinois.Will.countyCheck("Elwood.xlsx", "Elwood_results.xlsx", "Elwood");
        //CountyCheck.Illinois.Will.countyCheck("Joliet.xlsx", "Joliet_Results.xlsx", "Joliet");
        //CountyCheck.Illinois.Kendall.countyCheck("Joliet2.xlsx", "Joliet2_Results.xlsx", "Joliet");
    }

    public void test(){
        //CountyCheck.Illinois.Adams.countyCheck("test.xlsx", "testresults.xlsx", "QUINCY");
    }
}
