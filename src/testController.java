import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        CountyCheck.Illinois.Will.countyCheck("New Lenox Test.xlsx", "NEW_LENOX_TEST_RESULTS.xlsx", "NEW LENOX");
        CountyCheck.Illinois.Cook.countyCheck("test.xlsx", "testResults.xlsx", "Alsip");


        //CountyCheck.Illinois.Will.countyCheck("Elwood.xlsx", "Elwood_results.xlsx", "Elwood");
        //CountyCheck.Illinois.Will.countyCheck("Joliet.xlsx", "Joliet_Results.xlsx", "Joliet");
        //CountyCheck.Illinois.Kendall.countyCheck("Joliet2.xlsx", "Joliet2_Results.xlsx", "Joliet");
    }

    public void test(){
        //CountyCheck.Illinois.Adams.countyCheck("test.xlsx", "testresults.xlsx", "QUINCY");
    }
}
