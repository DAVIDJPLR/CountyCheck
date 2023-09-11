import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Year;
import java.util.*;

public class CountyCheck{

    public static final ArrayList<String> STATES = new ArrayList(Arrays.asList(new String[]{"ILLINOIS","LOUISIANA" , "TEXAS", "WASHINGTON"}));
    public static final ArrayList<String> ILLINOIS = new ArrayList(Arrays.asList(new String[]{"BOONE", "CHAMPAIGN", "DEKALB", "FAYETTE", "GRUNDY", "HENRY", "KANE", "KENDALL", "LIVINGSTON", "LAKE", "LASALLE", "MADISON", "MARION", "ST CLAIR", "WILL"}));
    public static final ArrayList<String> LOUISIANA = new ArrayList(Arrays.asList(new String[]{"EAST BATON ROUGE", "JEFFERSON", "LAFAYETTE", "ST TAMMANY"}));
    public static final ArrayList<String> TEXAS = new ArrayList(Arrays.asList(new String[]{"BRAZORIA"}));
    public static final ArrayList<String> WASHINGTON = new ArrayList(Arrays.asList(new String[]{"WALLA WALLA"}));

    private CountyCheck(){}

    public static void countyCheck (String sourceFileName, String resultFileName, String state, String county, String city){

        state = state.toUpperCase();
        county = county.toUpperCase();
        city = city.toUpperCase();

        switch (state){
            case "ILLINOIS":
                CountyCheck.Illinois.countyCheck(sourceFileName, resultFileName, county, city);
                break;
            case "LOUISIANA":
                CountyCheck.Louisiana.countyCheck(sourceFileName, resultFileName, county, city);
                break;
            case "TEXAS":
                CountyCheck.Texas.countyCheck(sourceFileName, resultFileName, county, city);
                break;
            case "WASHINGTON":
                CountyCheck.Washington.countyCheck(sourceFileName, resultFileName, county, city);
                break;
            default:
                noState(state);
                break;
        }
    }

    public static ArrayList<String> counties(String state){

        state = state.toUpperCase();

        switch (state){
//            case "CALIFORNIA":
//                return CALIFORNIA;
            case "ILLINOIS":
                return ILLINOIS;
            case "LOUISIANA":
                return LOUISIANA;
//            case "MICHIGAN":
//                return MICHIGAN;
//            case "MISSOURI":
//                return MISSOURI;
//            case "OKLAHOMA":
//                return OKLAHOMA;
//            case "OREGON":
//                return OREGON;
            case "TEXAS":
                return TEXAS;
            case "WASHINGTON":
                return WASHINGTON;
            default:
                return null;
        }
    }

    public class Alabama{

        private Alabama(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city) {

            switch (county) {
//                case "MONTGOMERY":
//                    CountyCheck.Alabama.Montgomery.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("ALABAMA", county);
                    break;
            }
        }

        public class Montgomery{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Montgomery(){}
        }
    }

    public class California{

        private California(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city) {

            switch (county) {
//                case "LOS ANGELES":
//                    CountyCheck.California.LosAngeles.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "ORANGE":
//                    CountyCheck.California.Orange.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "RIVERSIDE":
//                    CountyCheck.California.Riverside.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "SAN BERNARDINO":
//                    CountyCheck.California.SanBernardino.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "SANTA CLARA":
//                    CountyCheck.California.SantaClara.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("CALIFORNIA", county);
                    break;
            }
        }

        public class LosAngeles{
            private static final String url = "";
            private static final int implicitWait = 5;
            private LosAngeles(){}
        }

        public class Orange{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Orange(){}
        }

        public class Riverside{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Riverside(){}
        }

        public class SanBernardino{
            private static final String url = "https://arcpropertyinfo.sbcounty.gov/";
            private static final int implicitWait = 5;
            private SanBernardino(){}
        }

        public class SantaClara{
            private static final String url = "";
            private static final int implicitWait = 5;
            private SantaClara(){}
        }

    }

    public class Colorado{

        private Colorado(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city) {

            switch (county) {
//                case "BOULDER":
//                    CountyCheck.Colorado.Boulder.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("COLORADO", county);
                    break;
            }
        }

        public class Boulder{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Boulder(){}
        }

    }

    public class Illinois {

        private Illinois(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){

            switch (county){
                /**
                 * Start of DevNet
                 */
//                case "ADAMS":
//                    CountyCheck.Illinois.Adams.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "BOND":
//                    CountyCheck.Illinois.Bond.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "BOONE":
                    CountyCheck.Illinois.Boone.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "CARROLL":
//                    CountyCheck.Illinois.Carroll.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "CHAMPAIGN":
                    CountyCheck.Illinois.Champaign.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "CUMBERLAND":
//                    CountyCheck.Illinois.Cumberland.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "DEKALB":
                    CountyCheck.Illinois.Dekalb.countyCheck(sourceFileName, resultFileName,city);
                    break;
//                case "DOUGLAS":
//                    CountyCheck.Illinois.Douglas.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "FRANKLIN":
//                    CountyCheck.Illinois.Franklin.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "GRUNDY":
                    CountyCheck.Illinois.Grundy.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "HENRY":
                    CountyCheck.Illinois.Henry.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "JODAVIESS":
//                    CountyCheck.Illinois.JoDaviess.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "KANE":
                    CountyCheck.Illinois.Kane.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "KANKAKEE":
                    CountyCheck.Illinois.Kankakee.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "KENDALL":
                    CountyCheck.Illinois.Kendall.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "KNOX":
//                    CountyCheck.Illinois.Knox.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "LIVINGSTON":
                    CountyCheck.Illinois.Livingston.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "MADISON":
                    CountyCheck.Illinois.Madison.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "MARION":
                    CountyCheck.Illinois.Marion.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "MCDONOUGH":
//                    CountyCheck.Illinois.Mcdonough.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "MCHENRY":
//                    CountyCheck.Illinois.Mchenry.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "MCLEAN":
                    CountyCheck.Illinois.Mclean.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "OGLE":
//                    CountyCheck.Illinois.Ogle.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "PEORIA":
                    CountyCheck.Illinois.Peoria.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "PERRY":
//                    CountyCheck.Illinois.Perry.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "RANDOLPH":
//                    CountyCheck.Illinois.Randolph.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "ROCK ISLAND":
                    CountyCheck.Illinois.RockIsland.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "SALINE":
//                    CountyCheck.Illinois.Saline.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "ST CLAIR":
                    CountyCheck.Illinois.StClair.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "STEPHENSON":
//                    CountyCheck.Illinois.Stephenson.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "TAZEWELL":
//                    CountyCheck.Illinois.Tazewell.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "VERMILION":
                    CountyCheck.Illinois.Vermilion.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "WASHINGTON":
//                    CountyCheck.Illinois.Washington.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "WHITESIDE":
//                    CountyCheck.Illinois.Whiteside.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                /**
                 * End of DevNet
                 */

//                case "BUREAU":
//                    CountyCheck.Illinois.Bureau.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "CHRISTIAN":
//                    CountyCheck.Illinois.Christian.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "CLINTON":
//                    CountyCheck.Illinois.Clinton.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "FAYETTE":
                    CountyCheck.Illinois.Fayette.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "LAKE":
                    CountyCheck.Illinois.Lake.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "LASALLE":
                    CountyCheck.Illinois.Lasalle.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "MACON":
//                    CountyCheck.Illinois.Macon.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "MASSAC":
//                    CountyCheck.Illinois.Massac.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "SANGAMON":
//                    CountyCheck.Illinois.Sangamon.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "SHELBY":
//                    CountyCheck.Illinois.Shelby.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "WHITE":
//                    CountyCheck.Illinois.White.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "WILL":
                    CountyCheck.Illinois.Will.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "WILLIAMSON":
//                    CountyCheck.Illinois.Williamson.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "WINNEBAGO":
//                    CountyCheck.Illinois.Winnebago.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("ILLINOIS", county);
                    break;
            }
        }

        /**
         * Start of DevNet
         */
        public class Adams{
            private static final String url = "https://adamsil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Adams(){}
        }

        public class Bond{
            private static final String url = "https://bondil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Bond(){}
        }

        public class Boone{
            private static final String url = "https://booneil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Boone(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[3]/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[3]/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("BOONE");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "BOONE");
            }
        }

        public class Carroll{
            private static final String url = "https://carrollil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Carroll(){}
        }

        public class Champaign{
            private static final String url = "https://champaignil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Champaign(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("CHAMPAIGN");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "CHAMPAIGN");
            }
        }

        public class Cumberland{
            private static final String url = "https://cumberlandil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Cumberland(){}
        }

        public class Dekalb{
            private static final String url = "https://dekalbil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Dekalb(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("DEKALB");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");

                                if (Web.ID.exists(driver, "sketches-collapse-toggle")){
                                    Web.ID.click(driver,"sketches-collapse-toggle" );
                                }

                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "DEKALB");
            }
        }

        public class Douglas{
            private static final String url = "https://douglasil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Douglas(){}
        }

        public class Franklin{
            private static final String url = "https://franklinil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Franklin(){}
        }

        public class Grundy{

            private static final String url = "https://grundyil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Grundy(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("GRUNDY");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 50);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "GRUNDY");
            }
        }

        public class Henry{
            private static final String url = "https://henryil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Henry(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[3]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[3]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[3]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("HENRY");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "HENRY");
            }
        }

        public class JoDaviess{
            private static final String url = "https://jodaviessil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private JoDaviess(){}
        }

        public class Kane{

            private static final String url = "https://kaneil.devnetwedge.com/";
            private static final int implicitWait = 10;

            private Kane(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }


                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[1]/div[2]"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("KANE");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }
                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "Kane");
            }
        }

        public class Kankakee{

            private static final String url = "http://treasurer.k3county.net/";
            private static final int implicitWait = 5;
            private Kankakee(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("KANKAKEE");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "KANKAKEE");
            }
        }

        public class Kendall{

            private static final String url = "https://kendallil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Kendall(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                   Address current = new Address(undecideds.poll());

                   try{
                       Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                       Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                       Web.ID.type(driver, "parcel-search-street-name", current.getName());

                       Web.ID.type(driver, "parcel-search-community-name", city);

                       Web.hitEnter(driver);

                       boolean result = false;

                       if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                           if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[2]/td[2]\n")){
                               //multiple results

                               int count = 1;
                               boolean fail = false;

                               while ((result == false)&&(fail == false)){
                                   try{
                                       String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                       if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                           result = true;
                                       }
                                   } catch (Exception e){
                                       fail = true;
                                   }
                                   count += 1;
                               }
                               Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                           } else {
                               //no results
                           }
                       } else {
                           //result
                           result = true;
                       }


                       try {
                           if (result == true) {
                               //find info
                               current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                               current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                               String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                               current.setPropertyType(prop);
                               if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                   if (prop.contains("IMPROVED")) {
                                       current.setPropertyType("RESIDENTIAL");
                                   }
                               }

                               if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                   current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                   current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n"));
                               }

                               current.setConfirmedCounty("KENDALL");
                               current.setConfirmedCity(city);
                               current.setReason("COUNTY CHECK");
                               if (current.isException()) {
                                   Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                   exceptions.offer(current.toStringArrayList());
                               }
                           }
                       } catch (NoSuchElementException e){

                       }
                       driver.get(url);
                   } catch (Exception e){
                       undecideds.offer(current.toStringArrayList());
                       Excel.write(sourceFileName, collectionConvert(undecideds), header);
                       Excel.write(resultFileName, collectionConvert(exceptions), header);
                       problem(e.getMessage());
                       return;
                   }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "KENDALL");
            }
        }

        public class Knox{
            private static final String url = "https://knoxil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Knox(){}
        }

        public class Livingston{
            private static final String url = "https://livingstonil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Livingston(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("LIVINGSTON");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "LIVINGSTON");
            }
        }

        public class Madison{

            private static final String url = "http://reweb1.co.madison.il.us/";
            private static final int implicitWait = 5;
            private Madison(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[3]/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[3]/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("MADISON");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "MADISON");
            }
        }

        public class Marion{
            private static final String url = "https://marionil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Marion(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("MARION");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "MARION");
            }
        }

        public class Mcdonough{
            private static final String url = "https://mcdonoughil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Mcdonough(){}
        }

        public class Mchenry{
            private static final String url = "https://mchenryil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Mchenry(){}
        }

        public class Mclean{
            private static final String url = "https://mcleanil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Mclean(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[5]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("MCLEAN");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "MCLEAN");
            }
        }

        public class Ogle{
            private static final String url = "https://ogleil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Ogle(){}
        }

        public class Peoria{
            private static final String url = "http://propertytax.peoriacounty.org/";
            private static final int implicitWait = 5;
            private Peoria(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[8]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("PEORIA");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "PEORIA");
            }
        }

        public class Perry{
            private static final String url = "https://perryil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Perry(){}
        }

        public class Randolph{
            private static final String url = "https://randolphil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Randolph(){}
        }

        public class RockIsland{
            private static final String url = "https://rockislandil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private RockIsland(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("ROCK ISLAND");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "ROCK ISLAND");
            }
        }

        public class Saline{
            private static final String url = "https://salineil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Saline(){}
        }

        public class StClair{

            private static final String url = "https://stclairil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private StClair(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("ST CLAIR");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "ST CLAIR");
            }
        }

        public class Stephenson{
            private static final String url = "https://stephensonil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Stephenson(){}
        }

        public class Tazewell{
            private static final String url = "https://tazewellil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Tazewell(){}
        }

        public class Vermilion{
            private static final String url = "https://vermilionil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Vermilion(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.type(driver, "parcel-search-house-number-min", current.getNumber());
                        Web.ID.type(driver, "parcel-search-house-number-max", current.getNumber());

                        Web.ID.type(driver, "parcel-search-street-name", current.getName());

                        Web.ID.type(driver, "parcel-search-community-name", city);

                        Web.hitEnter(driver);

                        boolean result = false;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[1]/td[4]\n")){
                                //multiple results

                                int count = 1;
                                boolean fail = false;

                                while ((result == false)&&(fail == false)){
                                    try{
                                        String possible = Web.xPath.getText(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((possible.contains(current.getNumber().toUpperCase()))&&(possible.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                Web.xPath.click(driver, "/html/body/div[2]/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[4]\n");
                            } else {
                                //no results
                            }
                        } else {
                            //result
                            result = true;
                        }

                        try {
                            if (result == true) {
                                //find info
                                current.setPin(Web.xPath.getText(driver, "//html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[1]/div[2]"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" -")[0]);

                                String prop = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n").toUpperCase();
                                current.setPropertyType(prop);
                                if (current.getPropertyType().toUpperCase().equalsIgnoreCase("OTHER")) {
                                    if (prop.contains("IMPROVED")) {
                                        current.setPropertyType("RESIDENTIAL");
                                    }
                                }

                                if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[3]\n")) {
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                }

                                current.setConfirmedCounty("VERMILION");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                if (current.isException()) {
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        } catch (NoSuchElementException e){

                        }
                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "VERMILION");
            }
        }

        public class Washington{
            private static final String url = "https://washingtonil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Washington(){}
        }

        public class Whiteside{
            private static final String url = "https://whitesideil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Whiteside(){}
        }

        /**
         * End of DevNet
         */

        public class Bureau{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Bureau(){}
        }

        public class Christian{
            private static final String url = "https://christian.il.bhamaps.com/";
            private static final int implicitWait = 5;
            private Christian(){}
        }

        public class Clinton{
            private static final String url = "https://portico.mygisonline.com/html5/?viewer=clintonil";
            private static final int implicitWait = 5;
            private Clinton(){}
        }

        public class Fayette{
            private static final String url = "https://il1193.cichosting.com/atasportal/parcelSearch.aspx";
            private static final int implicitWait = 5;
            private Fayette(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                Actions search = new Actions(driver);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{

                        Web.ID.click(driver, "MainContent_btnReset2");

                        Web.ID.carefulClick(driver, "MainContent_ddlTaxYear");
                        search.sendKeys(Keys.ARROW_DOWN).perform();
                        search.sendKeys(Keys.ENTER).perform();

                        Web.ID.type(driver, "MainContent_txtStreetNumber", current.getNumber());

                        Web.ID.type(driver, "MainContent_txtStreetName", current.getName());

                        Web.ID.type(driver, "MainContent_txtCity", city);

                        Web.ID.click(driver, "MainContent_btnSearch2");

                        if (Web.xPath.exists(driver, "/html/body/form/table/tbody/tr[2]/td[2]/section/table[2]/tbody/tr/td/div/table/tbody/tr[2]/td[4]\n")){
                            //result
                            boolean found = false;
                            boolean fail = false;
                            int count = 2;

                            while ((found == false)&&(fail == false)){
                                try{
                                    String test = Web.xPath.getText(driver, "/html/body/form/table/tbody/tr[2]/td[2]/section/table[2]/tbody/tr/td/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                    if ((test.contains(current.getNumber().toUpperCase()))&&(test.contains(current.getName().toUpperCase()))){
                                        found = true;
                                    }
                                } catch (Exception e){
                                    fail = true;
                                }
                                count += 1;
                            }

                            if (found == true){
                                Web.xPath.click(driver, "/html/body/form/table/tbody/tr[2]/td[2]/section/table[2]/tbody/tr/td/div/table/tbody/tr[" + (count-1) + "]/td[1]/input\n");

                                Web.xPath.click(driver, "/html/body/form/table/tbody/tr[2]/td[1]/div/ul/li[4]/a\n");

                                try{
                                    current.setPin(Web.ID.getText(driver, "MainContent_txtParcelNumber"));
                                    current.setTaxCode(Web.ID.getTextFast(driver, "MainContent_txtTaxingCode"));
                                    current.setPropertyType(Web.ID.getTextFast(driver, "MainContent_txtPropertyClass"));

                                    Web.xPath.click(driver, "/html/body/form/table/tbody/tr[3]/td[1]/ul/li[5]/a\n");

                                    current.setLandValue(Web.xPath.getText(driver, "/html/body/form/table/tbody/tr[3]/td[2]/section/table[3]/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/table/tbody/tr[3]/td[2]/section/table[3]/tbody/tr[3]/td/div/table/tbody/tr[2]/td[3]\n"));

                                    current.setConfirmedCity(city);
                                    current.setConfirmedCounty("FAYETTE");
                                    current.setReason("COUNTY CHECK");

                                    if (current.isException()){
                                        Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 75);
                                        exceptions.offer(current.toStringArrayList());
                                    }

                                } catch (NoSuchElementException e){

                                }
                            }

                        } else {
                            //no result
                        }

                        driver.get(url);
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "FAYETTE");
            }
        }

        public class Lake{

            private static final String url = "https://tax.lakecountyil.gov/search/commonsearch.aspx?mode=realprop";
            private static final int implicitWait = 5;

            private Lake(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{

                        Web.ID.type(driver, "inpNo", current.getNumber());

                        Web.ID.type(driver, "inpStreet", current.getName());

                        Web.ID.type(driver, "inpZip1", city);
                        Web.hitEnter(driver);

                        Web.ID.click(driver, "btSearch");

                        if (Web.xPath.exists(driver, "/html/body/div[1]/div[3]/section/div/form/table/tbody/tr/td/div/div/table[2]/tbody/tr/td/table/tbody/tr[3]/td/center/table[1]/tbody/tr[1]/td/div/p\n")) {
                            //No result
                            Web.ID.clearTextBox(driver, "inpNo");
                            Web.ID.clearTextBox(driver, "inpStreet");
                        } else if(Web.xPath.exists(driver, "/html/body/div[1]/div[3]/section/div/form/table/tbody/tr/td/div/div/table[2]/tbody/tr/td[1]/table/tbody/tr[3]/td/center/table[2]/tbody/tr[3]/td[4]/div\n")){
                            boolean found = false;
                            boolean fail = false;
                            int count = 3;
                            while ((found == false)&&(fail == false)){
                                try{
                                    String prop = Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/table/tbody/tr/td/div/div/table[2]/tbody/tr/td[1]/table/tbody/tr[3]/td/center/table[2]/tbody/tr[" + count + "]/td[4]/div\n").toUpperCase();
                                    if ((prop.contains(current.getNumber().toUpperCase()))&&(prop.contains(current.getName().toUpperCase()))){
                                        found = true;
                                    }
                                } catch (Exception e){
                                    fail = true;
                                }
                                count += 1;
                            }

                            if (found == true){
                                Web.xPath.click(driver, "/html/body/div[1]/div[3]/section/div/form/table/tbody/tr/td/div/div/table[2]/tbody/tr/td[1]/table/tbody/tr[3]/td/center/table[2]/tbody/tr[" + (count-1) + "]/td[4]/div\n");

                                current.setPin((Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]\n")).split(" ")[1]);
                                current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[15]/td[2]\n"));
                                current.setTaxCode((Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[25]/td[2]\n")).split(" -")[0]);

                                Web.xPath.click(driver, "/html/body/div[1]/div[3]/div/nav/div/div/ul/li[19]/a/span\n");
                                current.setLandValue(Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[2]/td[4]\n"));
                                current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[2]/td[5]\n"));

                                current.setConfirmedCity(city);
                                current.setConfirmedCounty("LAKE");
                                current.setReason("COUNTY CHECK");

                                if (current.isException()){
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 100);
                                    exceptions.offer(current.toStringArrayList());
                                }

                                driver.get(url);
                            }

                        } else{
                            //result
                            current.setPin((Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]\n")).split(" ")[1]);
                            current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[15]/td[2]\n"));
                            current.setTaxCode((Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[25]/td[2]\n")).split(" -")[0]);

                            Web.xPath.click(driver, "/html/body/div[1]/div[3]/div/nav/div/div/ul/li[19]/a/span\n");
                            current.setLandValue(Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[2]/td[4]\n"));
                            current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[2]/td[5]\n"));

                            current.setConfirmedCity(city);
                            current.setConfirmedCounty("LAKE");
                            current.setReason("COUNTY CHECK");

                            if (current.isException()){
                                Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 100);
                                exceptions.offer(current.toStringArrayList());
                            }

                            driver.get(url);
                        }

                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "LAKE");
            }
        }

        public class Lasalle{

            private static final String url = "http://lasallecountysa.org/propertysearch/searchaddress.aspx";
            private static final int implicitWait = 5;
            private Lasalle(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    try{

                        Web.xPath.type(driver, "/html/body/div[1]/div[3]/div[1]/form/span/span/span/p[1]/font/input\n", current.getNumber());

                        Web.ID.type(driver, "mStrname", current.getName());

                        Web.xPath.click(driver, "/html/body/div[1]/div[3]/div[1]/form/span/span/span/font/span/p/span/input\n");

                        if (Web.xPath.getText(driver, "/html/body/form/div[3]/div[3]/div/div/font/span/div/table/tbody/tr[2]/td\n").toUpperCase().contains("NO RESULTS FOUND")){
                            //no result
                            driver.get(url);
                        } else{
                            //result
                            boolean found = false;
                            boolean fail = false;
                            int failCount = 0;
                            int count = 1;
                            while ((found == false)&&(fail == false)){
                                try{
                                    String testCity = Web.xPath.getTextFast(driver, "/html/body/form/div[3]/div[3]/div/div/font/span/div/table/tbody/tr[" + count + "]/td[3]\n");
                                    if (city.toUpperCase().equalsIgnoreCase(testCity.toUpperCase())){
                                        found = true;
                                    }
                                } catch (Exception e){
                                    failCount += 1;
                                    if (failCount >= 3) {
                                        fail = true;
                                    }
                                }
                                count += 1;
                            }
                            if (found == true){
                                Web.xPath.click(driver, "/html/body/form/div[3]/div[3]/div/div/font/span/div/table/tbody/tr[" + (count-1) + "]/td[1]/a\n");

                                current.setPin(Web.ID.getText(driver, "FormView1_pinLabel"));
                                current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/form/span/table/tbody/tr/td/table[2]/tbody/tr/td/span/b/table/tbody/tr[1]/td[1]/span/b/div/table/tbody/tr[1]/td[2]\n"));
                                current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/form/span/table/tbody/tr/td/table[4]/tbody/tr[2]/td/span/div/table/tbody/tr[2]/td[4]\n"));
                                current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/span/table/tbody/tr/td/table[4]/tbody/tr[2]/td/span/div/table/tbody/tr[2]/td[6]\n"));
                                current.setTaxCode(city);
                                current.setConfirmedCity(city);
                                current.setConfirmedCounty("LASALLE");
                                current.setReason("COUNTY CHECK");
                                if (current.isException()){
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                    exceptions.offer(current.toStringArrayList());
                                }
                            }
                            driver.get(url);
                        }
                    } catch (Exception e) {
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "ILLINOIS", "LASALLE");
            }
        }

        public class Macon{
            private static final String url = "https://maconcounty.maps.arcgis.com/apps/webappviewer/index.html?id=7b07a313cf5d40f78bb982e1b8811ce2";
            private static final int implicitWait = 5;
            private Macon(){}
        }

        public class Massac{
            private static final String url = "https://massac.il.bhamaps.com/";
            private static final int implicitWait = 10;
            private Massac(){}
        }

        public class Sangamon{
            private static final String url = "https://tax.co.sangamon.il.us/SangamonCountyWeb/app/searchByParcelNumber.action";
            private static final int implicitWait = 5;
            private Sangamon(){}
        }

        public class Shelby{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Shelby(){}
        }

        public class White{
            private static final String url = "https://portico.mygisonline.com/html5/?viewer=whiteil";
            private static final int implicitWait = 5;
            private White(){}
        }

        public class Will {

            private static final String url = "https://www.willcountysoa.com/propertysearch/searchaddress";
            private static final int implicitWait = 5;

            private Will(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{

                        Web.ID.click(driver, "reset123");

                        Web.ID.type(driver, "mStrnumS", current.getNumber());

                        Web.ID.type(driver, "mStrname", current.getName());

                        Web.ID.type(driver, "mStrcity", city);

                        Web.ID.click(driver, "img1");

                        boolean exist = true;

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td\n")){
                            if (Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td\n").equalsIgnoreCase("NO RESULT FOUND")){
                                exist = false;
                            }
                        }

                        if (!exist){
                            //No Result Found
                            driver.get(url);
                        } else {
                            //Result Found
                            boolean oneResult = false;
                            boolean err = false;
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td[2]\n")){
                                oneResult = true;
                            }
                            if(oneResult){
                                Web.xPath.click(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td[1]/a\n");
                            } else {
                                int count = 3;
                                try {
                                    boolean found = false;
                                    while (!found){
                                        List<String> res = Arrays.asList(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[" + count + "]/td[2]\n").split(" "));
                                        if (res.contains(current.getNumber())){
                                            if (res.contains(current.getName().toUpperCase())){
                                                found = true;
                                            }
                                        }
                                        count += 1;
                                    }
                                    Web.xPath.click(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[" + count + "]/td[1]/a\n");
                                } catch (Exception e){
                                    err = true;
                                }
                            }
                            if (!err){
                                Web.toWindow(driver, 1);
                                current.setTaxCode(city);
                                current.setConfirmedCounty("WILL");
                                current.setConfirmedCity(city);
                                current.setReason("COUNTY CHECK");
                                current.setPin(Web.ID.getText(driver, "FormView1_pinLabel"));
                                current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/form/span/div[1]/table/tbody/tr/td/table[6]/tbody/tr/td[1]/span/div[1]/table/tbody/tr/td[2]\n"));
                                current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/form/span/div[1]/table/tbody/tr/td/table[11]/tbody/tr[1]/td/span/div/table/tbody/tr[2]/td[4]\n"));
                                current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/span/div[1]/table/tbody/tr/td/table[11]/tbody/tr[1]/td/span/div/table/tbody/tr[2]/td[6]\n"));
                               if (current.isException()){
                                   Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 67);
                                   current.setStatus("EXCEPTION");
                                   exceptions.offer(current.toStringArrayList());
                               }
                                driver.close();
                                Web.toWindow(driver, 0);
                                driver.get(url);
                            } else {
                                driver.get(url);
                            }
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                    done(exceptions.size(), "ILLINOIS", "WILL");
            }

        }

        public class Williamson{
            private static final String url = "https://williamson.il.bhamaps.com/";
            private static final int implicitWait = 5;
            private Williamson(){}
        }

        public class Winnebago{
            private static final String url = "https://wingis.org/maps/PropertySearch.html";
            private static final int implicitWait = 5;
            private Winnebago(){}
        }
    }

    public class Louisiana{

        private Louisiana(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "AVOYELLES":
//                    CountyCheck.Louisiana.Avoyelles.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "EAST BATON ROUGE":
                    CountyCheck.Louisiana.EastBatonRouge.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "JEFFERSON":
                    CountyCheck.Louisiana.Jefferson.countyCheck(sourceFileName, resultFileName, city);
                    break;
                case "LAFAYETTE":
                    CountyCheck.Louisiana.Lafayette.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "LIVINGSTON":
//                    CountyCheck.Louisiana.Livingston.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "ORLEANS":
//                    CountyCheck.Louisiana.Orleans.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "ST LANDRY":
//                    CountyCheck.Louisiana.StLandry.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "ST TAMMANY":
                    CountyCheck.Louisiana.StTammany.countyCheck(sourceFileName, resultFileName, city);
                    break;
                default:
                    noCounty("LOUISIANA", county);
                    break;
            }
        }

        public class Avoyelles{
            private static final String url = "NO GO";
            private static final int implicitWait = 5;
            private Avoyelles(){}
        }

        public class EastBatonRouge{

            private static final String url = "https://city.brla.gov/gis/propertylookup.asp";
            private static final int implicitWait = 5;
            private EastBatonRouge(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    try{
                        //type number in
                        Web.xPath.clearTextBox(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[1]/input\n");
                        //Web.xPath.type(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[1]/input\n", current.getNumber());
                        Web.xPath.type(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[1]/input\n", "2300");

                        //type name
                        Web.xPath.clearTextBox(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[2]/input\n");
                        //Web.xPath.type(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[2]/input\n", current.getName());
                        Web.xPath.type(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[2]/input\n", "CHURCH");

                        //Click the Address button
                        Web.xPath.click(driver, "/html/body/div[1]/div/div/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[3]/input\n");

                        boolean addressFound = false;

                        if (Web.xPath.exists(driver, "/html/body/div[1]/div/div/div/div/div/div/div/p\n")){
                            //no result
                        } else {
                            //result
                            if (Web.xPath.exists(driver, "/html/body/div[1]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/a\n")){
                                //single result
                                if (Web.xPath.getTextFast(driver, "/html/body/div[1]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/a\n").toUpperCase().contains(city.toUpperCase())) {
                                    //good result
                                    System.out.println("test");
                                    Web.xPath.carefulClick(driver, "/html/body/div[1]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/a\n");
                                    System.out.println("clicked");
                                    addressFound = true;
                                }
                            } else {
                                //multiple result
                                boolean found = false;
                                boolean err = false;
                                int count = 1;

                                while ((!found)&(!err)){
                                    try{
                                        String txt = Web.xPath.getTextFast(driver, "/html/body/div[1]/div/div/div/div/div/div/div/table/tbody/tr[" + count  + "]/td[1]/a\n").toUpperCase();
                                        if((txt.contains(current.getNumber().toUpperCase() + " "))&(txt.contains(current.getName().toUpperCase()))&(txt.contains(city.toUpperCase()))){
                                            found = true;
                                        }
                                    } catch (Exception e){
                                        err = true;
                                    }
                                    count += 1;
                                }
                                if (found){
                                    Web.xPath.click(driver, "/html/body/div[1]/div/div/div/div/div/div/div/table/tbody/tr[" + (count-1)  + "]/td[1]/a\n");
                                    addressFound = true;
                                }
                            }
                            if (addressFound){
                                //Switch to correct window
                                Web.toWindow(driver, 1);
                                //Collect data
                                current.setPin(Web.xPath.getText(driver, "/html/body/table/tbody/tr[2]/td/div[1]/table[1]/tbody/tr[2]/td/span/a"));
                                current.setBuildingValue("1");
                                current.setLandValue("1");
                                current.setConfirmedCounty("EAST BATON ROUGE");
                                current.setConfirmedCity(city.toUpperCase());
                                current.setPropertyType("RESIDENTIAL");
                                current.setTaxCode(city.toUpperCase());

                                if (current.isException()){
                                    current.setReason("COUNTY CHECK");
                                    current.setStatus("EXCEPTION");
                                    //take screenshot
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);

                                    exceptions.offer(current.toStringArrayList());
                                }


                                //close window
                                driver.close();
                                //Switch back to original window
                                Web.toWindow(driver, 0);

                            }
                        }
                        driver.get(url);
                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "LOUISIANA", "EAST BATON ROUGE");
            }
        }

        public class Jefferson{
            private static final String url = "https://www.jpassessor.net/Parcel/Search?ParcelType=11";
            private static final int implicitWait = 5;
            private Jefferson(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                Actions down = new Actions(driver);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    try{
                        //Selects search by address
                        Web.ID.carefulClick(driver, "SelectedCriteriaIndex");
                        down.sendKeys(Keys.ARROW_DOWN).perform();

                        String search = current.getNumber() + " " + current.getName();
                        Web.ID.clearTextBox(driver, "SearchParams_Address");
                        Web.ID.type(driver, "SearchParams_Address", search);
                        Web.ID.click(driver, "SaveBtn");

                        if (Web.xPath.exists(driver, "/html/body/div[2]/main/div[2]/strong\n")) {
                            //Result
                            boolean found = false;
                            boolean err = false;
                            int count = 1;
                            while ((!found )&(!err)){
                                try{
                                    String result = Web.xPath.getText(driver, "/html/body/div[2]/main/div[3]/div/table/tbody/tr[" + count + "]/td[3]/a\n").toUpperCase();
                                    if ((result.contains(current.getNumber().toUpperCase() + " "))&(result.contains(current.getName().toUpperCase()))){
                                        found = true;
                                    }
                                } catch (Exception e){
                                    err = true;
                                }
                                count += 1;
                            }

                            if (found){
                                Web.xPath.click(driver, "/html/body/div[2]/main/div[3]/div/table/tbody/tr[" + (count-1) + "]/td[5]\n");

                                String one = Web.xPath.getText(driver, "/html/body/div[2]/main/div[4]/div[1]/div/div/div[2]/h5[1]\n");
                                String two = Web.xPath.getTextFast(driver, "/html/body/div[2]/main/div[4]/div[1]/div/div/div[2]/h5[2]\n");
                                current.setPin(((Web.xPath.getTextFast(driver, "/html/body/div[2]/main/div[4]/div[1]/div/div/div[2]\n")).split(two)[0]).split(one)[1]);


                                current.setPropertyType(Web.xPath.getText(driver, "/html/body/div[2]/main/div[4]/div[2]/div/table/tbody/tr[1]/td[1]\n"));
                                current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/main/div[4]/div[2]/div/table/tbody/tr[1]/td[2]\n"));
                                current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/main/div[4]/div[2]/div/table/tbody/tr[1]/td[2]\n"));
                                current.setTaxCode(city);
                                current.setConfirmedCounty("JEFFERSON");
                                current.setConfirmedCity(city.toUpperCase());

                                if (current.isException()){
                                    current.setReason("COUNTY CHECK");
                                    current.setStatus("EXCEPTION");
                                    //take screenshot
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 33);

                                    exceptions.offer(current.toStringArrayList());
                                }

                            }
                        }
                        driver.get(url);
                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "LOUISIANA", "JEFFERSON");
            }
        }

        public class Lafayette{
            private static final String url = "https://portico.mygisonline.com/html5/?viewer=lafayettela";
            private static final int implicitWait = 10;
            private Lafayette(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                Actions search = new Actions(driver);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    String address = current.getNumber() + " " + current.getName();
                    try{
                        //Click basic search button
                        Web.xPath.click(driver, "/html/body/div[2]/div/div[1]/div/div[1]/div[4]/div/div/div[2]/div/ul/li[19]/button\n");
                        //Select Property Search as criteria
                        Web.xPath.click(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[17]/div/div[3]/div/div/form/div[1]/div/div[1]\n");
                        search.sendKeys("P").perform();
                        Web.hitEnter(driver);
                        //Type the search address in the search box
                        Web.xPath.type(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[17]/div/div[3]/div/div/form/div[1]/div/div[3]/div/div/div/div[2]/div/div/div\n", address);
                        //Hit Enter
                        Web.hitEnter(driver);

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[3]/ul[32]/li[1]/div[4]/div/div/a\n")){
                            //No Results
                        } else if (Web.xPath.exists(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[17]/div/div[3]/div/div/form/div[1]/div/div[1]/div/div/div/div[1]/div/div/blockquote/p\n")){
                            //No Result
                        } else {
                            //Results
                            boolean found = false;
                            boolean err = false;
                            int count = 1;

                            while ((!found)&(!err)){
                                try {
                                    String result = Web.xPath.getText(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[17]/div/div[3]/div/div/div[3]/div/ul/li[" + count + "]/div/span[2]/div/em[3]\n").toUpperCase();
                                    if ((result.contains(current.getNumber().toUpperCase() + " "))&(result.contains(current.getName().toUpperCase()))&(result.contains(city.toUpperCase()))){
                                        found = true;
                                    }
                                } catch (Exception e){
                                    err = true;
                                }
                                count += 1;
                            }
                            if (found){
                                Web.xPath.click(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[17]/div/div[3]/div/div/div[3]/div/ul/li[" + (count-1) + "]/div/span[2]/div/a[2]\n");

                                String split = Web.xPath.getText(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[18]/div/div[3]/div/div/form/div[1]/div/div[2]/div/fieldset/div/div/div/div/blockquote/p[1]/strong[2]");
                                current.setPin((Web.xPath.getText(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[18]/div/div[3]/div/div/form/div[1]/div/div[2]/div/fieldset/div/div/div/div/blockquote/p[1]\n").split(split)[0]).split(": ")[1]);

                                Web.xPath.click(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[18]/div/div[3]/div/div/form/div[1]/div/div[1]/div/div/div/div[3]\n");
                                search.sendKeys("V").perform();
                                Web.hitEnter(driver);

                                try{
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[18]/div/div[3]/div/div/form/div[1]/div/div[3]/div/fieldset/div/div/div/div/table[1]/tbody/tr[1]/td[3]\n"));
                                } catch (Exception e){
                                    current.setBuildingValue("0");
                                }
                                try{
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div[18]/div/div[3]/div/div/form/div[1]/div/div[3]/div/fieldset/div/div/div/div/table[1]/tbody/tr[2]/td[3]\n"));
                                } catch (Exception e){
                                    current.setLandValue("0");
                                }

                                current.setConfirmedCounty("LAFAYETTE");
                                current.setConfirmedCity(city);
                                current.setTaxCode(city);
                                current.setPropertyType("RESIDENTIAL");

                                if (current.isException()){
                                    current.setReason("COUNTY CHECK");
                                    current.setStatus("EXCEPTION");
                                    //Take Screenshot
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 100);
                                    exceptions.offer(current.toStringArrayList());
                                }
                            }
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "LOUISIANA", "ST TAMMANY");
            }
        }

        public class Livingston{
            private static final String url = "https://atlas.geoportalmaps.com/livingston";
            private static final int implicitWait = 5;
            private Livingston(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                Actions search = new Actions(driver);

                if (Web.xPath.exists(driver, "/html/body/div[28]/div[3]/div/button\n")) {
                    Web.xPath.click(driver, "/html/body/div[28]/div[3]/div/button\n");
                }

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    try{
                        //click on searchh button
                        Web.ID.click(driver, "showSearch");
                        //select parcel address from drop down
                        Web.ID.click(driver, "queryDDL");
                        search.sendKeys("PARCEL AADDRESS").perform();
                        Web.hitEnter(driver);
                        //Enter address number
                        Web.ID.type(driver, "3039", current.getNumber());
                        //Enter address name
                        Web.ID.click(driver, "7469");
                        search.sendKeys(current.getName());
                        Web.hitEnter(driver);
                        //Hit search button
                        Web.ID.click(driver, "submit");

                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "LOUISIANA", "ST TAMMANY");
            }
        }

        public class Orleans{
//            private static final String url = "https://beacon.schneidercorp.com/Application.aspx?AppID=979&LayerID=19792&PageTypeID=2&PageID=8661";
            private static final String url = "CAPTCHA";
            private static final int implicitWait = 20;
            private Orleans(){}

//            public static void countyCheck (String sourceFileName, String resultFileName, String city){
//
//                String screenshotPath = screenShotPath(resultFileName);
//
//                ArrayList<String> header = (new Address()).toStringArrayList();
//
//                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
//                if (undecideds == null){return;}
//
//                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);
//
//                RemoteWebDriver driver = Web.chrome(implicitWait);
//                driver.get(url);
//
//                //Check to see if message is there and click on message before entering main webpage
//                if (Web.xPath.exists(driver, "/html/body/div[4]/div/div/div[2]/div[2]/a[1]")) {
//                    Web.xPath.click(driver, "/html/body/div[4]/div/div/div[2]/div[2]/a[1]");
//                }
//
//                Actions search = new Actions(driver);
//
//                while (!(undecideds.peek() == null)){
//                    Address current = new Address(undecideds.poll());
//                    try{
////                        String searchAddress = (current.getNumber() + " " + current.getName()).toUpperCase();
//                        String searchAddress = "800 RENDON";
//                        //type search criteria into search box
//                        Web.ID.type(driver, "ctlBodyPane_ctl01_ctl01_txtAddress", searchAddress);
//                        //Click the search button
//                        Web.ID.click(driver, "ctlBodyPane_ctl01_ctl01_btnSearch");
//
//                        if (Web.xPath.exists(driver, "/html/body/form/div[5]/div/div[1]/main/div/h2\n")){
//                            //No Results
//                            System.out.println("No Result");
//                        } else {
//                            //Results
//                            System.out.println("Result");
//                        }
//
//                    } catch (Exception e){
//                        e.printStackTrace();
//                        undecideds.offer(current.toStringArrayList());
////                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
////                        Excel.write(resultFileName, collectionConvert(exceptions), header);
//                        problem(e.getMessage());
//                        return;
//                    }
//                }
////                Excel.write(sourceFileName, collectionConvert(undecideds), header);
////                Excel.write(resultFileName, collectionConvert(exceptions), header);
//                driver.close();
//                done(exceptions.size(), "LOUISIANA", "Orleans");
//            }
        }

        public class StLandry{
            private static final String url = "No Go";
            private static final int implicitWait = 5;
            private StLandry(){}
        }

        public class StTammany{

            private static final String url = "https://arist.stassessor.org/aristpwa/Search";
            private static final int implicitWait = 5;
            private StTammany(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                Actions search = new Actions(driver);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());
                    try{
                        //Clear Form
                        Web.xPath.click(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[1]/div[2]/button[1]\n");
                        //Choose previous tax year
                        Web.xPath.carefulClick(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div[2]\n");
                        Web.ID.carefulClick(driver, "react-select-2-option-1");
                        //Type street number
                        Web.xPath.click(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/div/label\n");
                        search.sendKeys(current.getNumber()).perform();
                        //Type street name
                        Web.xPath.click(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/div[4]/div/label\n");
                        search.sendKeys(current.getName()).perform();
                        //Hit search
                        Web.xPath.click(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[1]/div[2]/button[2]\n");

                        if (Web.xPath.exists(driver, "/html/body/div[1]/div[1]/div[2]/div[1]/button/span[1]\n")){
                            //No Result
                            Web.xPath.click(driver, "/html/body/div[1]/div[1]/div[2]/div[1]/button/span[1]\n");
                        } else {
                            boolean found = false;
                            if (Web.xPath.exists(driver, "System.out.println(Web.xPath.exists(driver, \"/html/body/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/div[1]\\n\"))")){
                                //One Result
                                found = true;
                            } else {
                                //Multiple Result
                                boolean result = false;
                                boolean err = false;
                                int count = 1;
                                while ((!result)&(!err)){
                                    try{
                                        String test = Web.xPath.getTextFast(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr[" + count + "]/td[8]\n").toUpperCase();
                                        if ((test.contains(current.getNumber().toUpperCase() + " "))&(test.contains(current.getName().toUpperCase()))){
                                            result = true;
                                        }
                                        count += 1;
                                    } catch (Exception e){
                                        err = true;
                                    }
                                }
                                if (result == true){
                                    Web.xPath.click(driver, "/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/table/tbody/tr[" + (count-1) + "]/td[8]\n");
                                    found = true;
                                }
                            }

                            if (found){
                                if (Web.xPath.getTextFast(driver, "/html/body/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]\n").toUpperCase().contains(city.toUpperCase())) {
                                    current.setPin(Web.xPath.getText(driver, "/html/body/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div/div[2]\n"));
                                    current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]\n"));
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[1]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[1]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]\n"));
                                    current.setConfirmedCounty("ST TAMMANY");
                                    current.setConfirmedCity(city);
                                    current.setPropertyType("RESIDENTIAL");
                                    if (current.isException()){
                                        current.setReason("COUNTY CHECK");
                                        current.setStatus("EXCEPTION");
                                        //Take Screenshot
                                        Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 75);
                                        exceptions.offer(current.toStringArrayList());
                                    }
                                }
                                driver.get(url);
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "LOUISIANA", "ST TAMMANY");
            }
        }
    }

    public class Michigan{

        private Michigan(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "OAKLAND":
//                    CountyCheck.Michigan.Oakland.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("MICHIGAN", county);
                    break;
            }
        }

        public class Oakland{
            private static final String url = "https://apps.oakgov.com/etax0001/Controller?operation=";
            private static final int implicitWait = 5;
            private Oakland(){}
        }

    }

    public class Missouri{

        private Missouri(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "ANDREW":
//                    CountyCheck.Missouri.Andrew.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "CALLAWAY":
//                    CountyCheck.Missouri.Callaway.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "COLE":
//                    CountyCheck.Missouri.Cole.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "MISSISSIPPI":
//                    CountyCheck.Missouri.Mississippi.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "RAY":
//                    CountyCheck.Missouri.Ray.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "ST FRANCOIS":
//                    CountyCheck.Missouri.Stfrancois.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "ST LOUIS":
//                    CountyCheck.Missouri.Stlouis.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("MISSOURI", county);
                    break;
            }
        }

        public class Andrew{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Andrew(){}
        }

        public class Callaway{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Callaway(){}
        }

        public class Cole{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Cole(){}
        }

        public class Mississippi{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Mississippi(){}
        }

        public class Ray{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Ray(){}
        }

        public class Stfrancois{
            private static final String url = "https://stfrancois.missouriassessors.com/search.php";
            private static final int implicitWait = 5;
            private Stfrancois(){}
        }

        public class Stlouis{
            private static final String url = "https://revenue.stlouisco.com/ias/";
            private static final int implicitWait = 5;
            private Stlouis(){}
        }

    }

    public class Oklahoma{

        private Oklahoma(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "GARFIELD":
//                    CountyCheck.Oklahoma.Garfield.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("OKLAHOMA", county);
                    break;
            }
        }

        public class Garfield{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Garfield(){}
        }

    }

    public class Oregon{

        private Oregon(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "COOS":
//                    CountyCheck.Oregon.Coos.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("OREGON", county);
                    break;
            }
        }

        public class Coos{
            private static final String url = "https://records.co.coos.or.us/pso";
            private static final int implicitWait = 5;
            private Coos(){}
        }

    }

    public class Texas{

        private Texas(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "ATASCOSA":
//                    CountyCheck.Texas.Atascosa.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "BOWIE":
//                    CountyCheck.Texas.Bowie.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "BRAZORIA":
                    CountyCheck.Texas.Brazoria.countyCheck(sourceFileName, resultFileName, city);
                    break;
//                case "DALLAS":
//                    CountyCheck.Texas.Dallas.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "GALVESTON":
//                    CountyCheck.Texas.Galveston.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "GRAYSON":
//                    CountyCheck.Texas.Grayson.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "HIDALGO":
//                    CountyCheck.Texas.Hidalgo.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "LIBERTY":
//                    CountyCheck.Texas.Liberty.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "MCLENNAN":
//                    CountyCheck.Texas.Mclennan.countyCheck(sourceFileName, resultFileName, city);
//                    break;
//                case "WILSON":
//                    CountyCheck.Texas.Wilson.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                default:
                    noCounty("TEXAS", county);
                    break;
            }
        }

        public class Atascosa{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Atascosa(){}
        }

        public class Bowie{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Bowie(){}
        }

        public class Brazoria{
            private static final String url = "https://propaccess.trueautomation.com/clientdb/propertysearch.aspx?cid=51";
            private static final int implicitWait = 5;
            private Brazoria(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.click(driver, "propertySearchOptions_advanced");

                        Web.ID.type(driver, "propertySearchOptions_streetNumber", current.getNumber());

                        Web.ID.type(driver, "propertySearchOptions_streetName", current.getName());

                        String prevYear = String.valueOf((Year.now().getValue())-1);
                        Web.ID.type(driver, "propertySearchOptions_taxyear", prevYear);
                        Web.hitEnter(driver);

                        Web.ID.click(driver, "propertySearchOptions_searchAdv");

                        System.out.println(Web.ID.getText(driver, "propertySearchResults_pageHeading"));
                        if (Web.ID.getText(driver, "propertySearchResults_pageHeading").equalsIgnoreCase("None found.")){
                            //no result
                            driver.get(url);
                        } else {
                            //result
                            try{
                                int res = 0;
                                boolean found = false;
                                while (found == false){
                                    System.out.println(Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)));
                                    if ((Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)).split(" ")[0].equalsIgnoreCase(current.getNumber()))&&(Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)).contains(current.getName()))&&(Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)).contains(city))){
                                        //result
                                        found = true;
                                    }
                                    res += 1;
                                }
                                if (found == true) {
                                    //get info
                                    Web.xPath.click(driver, ("/html/body/form/div[3]/div[2]/table/tbody/tr[" + (res + 1) + "]/td[10]/a\n"));
                                    //expand all
                                    Web.xPath.click(driver, "/html/body/form/div/div[5]/div[1]/span/input\n");

                                    current.setPin(Web.xPath.getText(driver, "/html/body/form/div/div[5]/div[3]/table/tbody/tr[2]/td[2]\n"));
                                    current.setPropertyType("RESIDENTIAL");
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/div/div[5]/div[5]/table/tbody/tr[2]/td[3]\n"));
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/form/div/div[5]/div[5]/table/tbody/tr[4]/td[3]\n"));
                                    current.setConfirmedCounty("BRAZORIA");
                                    current.setConfirmedCity(city);
                                    current.setTaxCode(city);
                                    current.setReason("COUNTY CHECK");

                                    System.out.println(current.isException());

                                    if (current.isException()) {
                                        Web.takeScreenshot(driver, screenshotPath + "\\" + current + ".JPG", 67);
                                        exceptions.offer(current.toStringArrayList());
                                    }
                                    driver.get(url);

                                } else{
                                    //no info
                                    driver.get(url);
                                }

                            } catch (Exception e){
                                //no result
                                driver.get(url);
                            }
                        }


                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "TEXAS", "BRAZORIA");
            }
        }

        public class Dallas{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Dallas(){}
        }

        public class Galveston{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Galveston(){}
        }

        public class Grayson{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Grayson(){}
        }

        public class Hidalgo{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Hidalgo(){}
        }

        public class Liberty{
            private static final String url = "https://esearch.libertycad.com/";
            private static final int implicitWait = 5;
            private Liberty(){}
        }

        public class Mclennan{
            private static final String url = "https://esearch.mclennancad.org/";
            private static final int implicitWait = 5;
            private Mclennan(){}
        }

        public class Wilson{
            private static final String url = "";
            private static final int implicitWait = 5;
            private Wilson(){}
        }

    }

    public class Washington{

        private Washington(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city){
            switch (county){
//                case "KING":
//                    CountyCheck.Washington.kING.countyCheck(sourceFileName, resultFileName, city);
//                    break;
                case "WALLA WALLA":
                    CountyCheck.Washington.WallaWalla.countyCheck(sourceFileName, resultFileName, city);
                    break;
                default:
                    noCounty("WASHINGTON", county);
                    break;
            }
        }

        public class King{
            private static final String url = "";
            private static final int implicitWait = 5;
            private King(){}
        }

        public class WallaWalla{
            private static final String url = "https://propertysearch.co.walla-walla.wa.us/PropertyAccess/propertysearch.aspx?cid=0";
            private static final int implicitWait = 5;
            private WallaWalla(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city){

                String screenshotPath = screenShotPath(resultFileName);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName);
                if (undecideds == null){return;}

                Queue<ArrayList<String>> exceptions = initExceptions(resultFileName);

                RemoteWebDriver driver = Web.chrome(implicitWait);
                driver.get(url);

                while (!(undecideds.peek() == null)){
                    Address current = new Address(undecideds.poll());

                    try{
                        Web.ID.click(driver, "propertySearchOptions_advanced");

                        Web.ID.type(driver, "propertySearchOptions_streetNumber", current.getNumber());

                        Web.ID.type(driver, "propertySearchOptions_streetName", current.getName());

                        String prevYear = String.valueOf((Year.now().getValue())-1);
                        Web.ID.type(driver, "propertySearchOptions_taxyear", prevYear);
                        Web.hitEnter(driver);

                        Web.ID.click(driver, "propertySearchOptions_search");

                        System.out.println(Web.ID.getText(driver, "propertySearchResults_pageHeading"));
                        if (Web.ID.getText(driver, "propertySearchResults_pageHeading").equalsIgnoreCase("None found.")){
                            //no result
                            driver.get(url);
                        } else {
                            //result
                            try{
                                int res = 0;
                                boolean found = false;
                                while (found == false){
                                    System.out.println(Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)));
                                    if ((Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)).split(" ")[0].equalsIgnoreCase(current.getNumber()))&&(Web.ID.getTextFast(driver, ("propertySearchResults_address" + res)).contains(current.getName()))){
                                        //result
                                        found = true;
                                    }
                                    res += 1;
                                }
                                if (found == true) {
                                    //get info
                                    Web.xPath.click(driver, ("/html/body/form/div[5]/div[2]/table/tbody/tr[" + (res+1) + "]/td[11]/a\n"));
                                    //expand all
//                                    Web.xPath.click(driver, "/html/body/form/div/div[5]/div[1]/span/input\n");

                                    current.setPin(Web.xPath.getText(driver, "/html/body/form/div[3]/div[5]/div[3]/table/tbody/tr[2]/td[2]\n"));
                                    current.setPropertyType("RESIDENTIAL");
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/div[3]/div[5]/div[7]/table/tbody/tr[2]/td[3]\n"));
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/form/div[3]/div[5]/div[7]/table/tbody/tr[4]/td[3]\n"));
                                    current.setConfirmedCounty("WALLA WALLA");
                                    current.setConfirmedCity(city);
                                    current.setTaxCode(city);
                                    current.setReason("COUNTY CHECK");

                                    System.out.println(current.isException());

                                    if (current.isException()) {
                                        Web.takeScreenshot(driver, screenshotPath + "\\" + current + ".JPG", 33);
                                        exceptions.offer(current.toStringArrayList());
                                    }
                                    driver.get(url);

                                } else{
                                    //no info
                                    driver.get(url);
                                }

                            } catch (Exception e){
                                //no result
                                driver.get(url);
                            }
                        }


                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        problem(e.getMessage());
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                done(exceptions.size(), "WASHINGTON", "WALLA WALLA");
            }
        }

    }

    public static Collection<Collection<String>> collectionConvert(Queue<ArrayList<String>> in){
        Collection<Collection<String>> out = new LinkedList<>();
        for (ArrayList x : in){
            out.add(x);
        }
        return out;
    }

    public static void createFolder(String folderPath){
        File temp = new File(folderPath);
        boolean test = temp.mkdir();
        if (!test) {
            problem("Unable to create folder: " + folderPath);
        }
    }

    public static String screenShotPath(String resultFileName){
        String screenshotPath = resultFileName.split("\\.")[0] + "_SCREENSHOTS.";
        if (!(Files.isDirectory(Paths.get(screenshotPath)))){
            createFolder(screenshotPath);
        }

        return screenshotPath;
    }

    public static Queue<ArrayList<String>> readUndecideds(String sourceFileName){

        Queue<ArrayList<String>> undecideds = Excel.read(sourceFileName);
        try {
            if (undecideds == null) {
                throw new Exception("No undecided addresses were found");
            }
        } catch (Exception e){
            problem(e.getMessage());
            return null;
        }
        undecideds.poll();

        return undecideds;
    }

    public static Queue<ArrayList<String>> initExceptions(String resultFileName){
        Queue<ArrayList<String>> exceptions = new LinkedList<>();

        if (Files.isRegularFile(Paths.get(resultFileName))) {
            exceptions = Excel.read(resultFileName);
            exceptions.poll();
        }

        return exceptions;
    }

    public static void done(int exceptions, String state, String county){
        Alert countyError = new Alert(Alert.AlertType.INFORMATION);
        countyError.setTitle(county + ", " + state + "county check complete");
        countyError.setHeaderText(exceptions + " exceptions found!");
        countyError.getButtonTypes().remove(0);
        countyError.getButtonTypes().add(ButtonType.OK);
        countyError.showAndWait();
    }

    public static void noCounty (String state, String county){
        Alert countyError = new Alert(Alert.AlertType.WARNING);
        countyError.setTitle("County not yet supported");
        countyError.setHeaderText(county + ", " + state + " is not yet supported by County Checker");
        countyError.getButtonTypes().remove(0);
        countyError.getButtonTypes().add(ButtonType.OK);
        countyError.showAndWait();
    }

    public static void noState (String state){
        Alert stateError = new Alert(Alert.AlertType.WARNING);
        stateError.setTitle("State not yet supported");
        stateError.setHeaderText(state + " is not yet supported by County Checker");
        stateError.getButtonTypes().remove(0);
        stateError.getButtonTypes().add(ButtonType.OK);
        stateError.showAndWait();
    }

    public static void problem (String error){
        Alert problemError = new Alert(Alert.AlertType.ERROR);
        problemError.setTitle("An error has occurred");
        problemError.setHeaderText("An error has occurred");
        Text message = new Text("Error message: \n" + error);
        message.setWrappingWidth(1000);
        problemError.getDialogPane().setContent(message);
        problemError.getButtonTypes().remove(0);
        problemError.getButtonTypes().add(ButtonType.OK);
        //problemError.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        problemError.showAndWait();
    }

}
