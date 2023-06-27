import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CountyCheck {

    public static final ArrayList<String> STATES = new ArrayList(Arrays.asList(new String[]{"ILLINOIS"}));
    public static final ArrayList<String> ILLINOIS = new ArrayList(Arrays.asList(new String[]{"WILL"}));

    private CountyCheck(){}

    public static void countyCheck (String sourceFileName, String resultFileName, String state, String county, String city, JPanel currentFrame){

        state = state.toUpperCase();
        county = county.toUpperCase();
        city = city.toUpperCase();

        switch (state){
            case "ILLINOIS":
                CountyCheck.Illinois.countyCheck(sourceFileName, resultFileName, county, city, currentFrame);
                break;
            default:
                JOptionPane.showMessageDialog(currentFrame, "There is currently no support for " + state);
                break;
        }
    }

    public static ArrayList<String> counties(String state){

        state = state.toUpperCase();

        switch (state){
            case "ILLINOIS":
                return ILLINOIS;
            default:
                return null;
        }
    }

    public class Illinois {

        private Illinois(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city, JPanel currentFrame){

            switch (county){
                case "WILL":
                    CountyCheck.Illinois.Will.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "KANE":
                    CountyCheck.Illinois.Kane.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "LAKE":
                    CountyCheck.Illinois.Lake.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "LASALLE":
                    CountyCheck.Illinois.Lasalle.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "KENDALL":
                    CountyCheck.Illinois.Kendall.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "GRUNDY":
                    CountyCheck.Illinois.Grundy.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "ST CLAIR":
                    CountyCheck.Illinois.StClair.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "MADISON":
                    CountyCheck.Illinois.Madison.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "KANKAKEE":
                    CountyCheck.Illinois.Kankakee.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                case "BOONE":
                    CountyCheck.Illinois.Boone.countyCheck(sourceFileName, resultFileName, city, currentFrame);
                    break;
                default:
                    JOptionPane.showMessageDialog(currentFrame, "There is currently no support for " + county + " county, Illinois");
                    break;
            }
        }

        public class Will {

            private static final String url = "https://www.willcountysoa.com/propertysearch/searchaddress";
            private static final int implicitWait = 5;

            private Will(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame) {

                String screenshotPath = resultFileName.split("\\.")[0] + "_SCREENSHOTS.";
                if (!(Files.isDirectory(Paths.get(screenshotPath)))){
                    createFolder(screenshotPath, currentFrame);
                }

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = Excel.read(sourceFileName);
                try {
                    if (undecideds == null) {
                        throw new Exception("No undecided addresses were found");
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(new JPanel(), "No undecided addresses were found");
                    return;
                }
                undecideds.poll();

                Queue<ArrayList<String>> exceptions = new LinkedList<>();

                if (Files.isRegularFile(Paths.get(resultFileName))) {
                    exceptions = Excel.read(resultFileName);
                    exceptions.poll();
                }

                RemoteWebDriver driver = Web.chrome(implicitWait);

                driver.get(url);

                while (!(undecideds.peek() == null)){
                    System.out.println("Still Going");
                    Address current = new Address(undecideds.poll());
                    try {
                        Web.ID.click(driver, "reset123");

                        Web.ID.type(driver, "mStrnumS", current.getNumber());

                        Web.ID.type(driver, "mStrname", current.getName());

                        Web.ID.type(driver, "mStrcity", city);

                        Web.ID.click(driver, "img1");

                        if ((Web.xPath.getText(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td\n")).equalsIgnoreCase("NO RESULTS FOUND")) {
                            //No Result
                            Web.xPath.click(driver, "/html/body/div[1]/div[2]/ul/li[3]/a\n");
                        } else {
                            //Result
                            Web.xPath.click(driver, "/html/body/div[2]/div[1]/div[1]/div/form/div[3]/div/div/div/font/span/div/table/tbody/tr[2]/td[1]/a\n");

                            Web.toWindow(driver, 1);

                            current.setPin(Web.ID.getText(driver, "FormView1_pinLabel"));
                            current.setPropertyType(Web.ID.getTextFast(driver, "FormView1_DetailsView9"));
                            current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/form/span/div[1]/table/tbody/tr/td/table[11]/tbody/tr[1]/td/span/div/table/tbody/tr[2]/td[4]\n"));
                            current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/form/span/div[1]/table/tbody/tr/td/table[11]/tbody/tr[1]/td/span/div/table/tbody/tr[2]/td[6]\n"));
                            current.setTaxCode(city.toUpperCase());
                            current.setConfirmedCounty("WILL");
                            current.setConfirmedCity(city.toUpperCase());
                            current.setReason("COUNTY CHECK");

                            if (current.isException()){
                                //is Exception
                                Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 50);
                                exceptions.offer(current.toStringArrayList());
                            }
                            driver.close();
                            Web.toWindow(driver, 0);
                            Web.xPath.click(driver, "/html/body/div[1]/div[2]/ul/li[3]/a\n");

                        }
                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame,"An error has occurred while county checking " + current.toString() + "\nError: Selenium:Will" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Kane{

            private static final String url = "https://kaneil.devnetwedge.com/";
            private static final int implicitWait = 10;

            private Kane(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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

                        if (Web.xPath.exists(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr/td\n")){
                            if (Web.xPath.getText(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr/td\n").toUpperCase().contains("NO DATA AVAILABLE IN TABLE")) {
                                //No Result
                                Web.xPath.click(driver, "/html/body/div[1]/div/div[2]/ul[3]/li[1]/a\n");
                            } else {
                                //multiple results
                                boolean result = false;
                                boolean fail = false;
                                int count = 1;
                                while ((result == false)&&(fail == false)){
                                    try {
                                        String temp = Web.xPath.getTextFast(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr[" + count + "]/td[4]\n").toUpperCase();
                                        if ((temp.contains(current.getNumber().toUpperCase()))&&(temp.contains(current.getName().toUpperCase()))&&(temp.contains(city.toUpperCase()))){
                                            result = true;
                                        }
                                    } catch (Exception e){
                                        fail = true;
                                    }
                                    count += 1;
                                }
                                if (result == true) {
                                    Web.xPath.click(driver, "/html/body/div[2]/div[3]/div/table/tbody/tr[" + (count - 1) + "]/td[4]\n");

                                    current.setPin(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                    current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n"));
                                    current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n"));
                                    current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                    current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                    current.setConfirmedCounty("KANE");
                                    current.setConfirmedCity(city.toUpperCase());
                                    current.setReason("COUNTY CHECK");

                                    if (current.isException()){
                                        Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 50);
                                        exceptions.offer(current.toStringArrayList());
                                    }
                                }
                                Web.xPath.click(driver, "/html/body/div[1]/div/div[2]/ul[3]/li[1]/a\n");
                            }
                        } else {
                            if (Web.xPath.exists(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n")){
                                //single result
                                current.setPin(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[1]/div[2]\n"));
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n"));
                                current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[4]/div[2]/table/tbody/tr[4]/td[1]/div[2]\n"));
                                current.setLandValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[2]\n"));
                                current.setBuildingValue(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[7]/div[2]/table/tbody/tr[1]/td[3]\n"));
                                current.setConfirmedCounty("KANE");
                                current.setConfirmedCity(city.toUpperCase());
                                current.setReason("COUNTY CHECK");

                                if (current.isException()){
                                    Web.takeScreenshot(driver, (screenshotPath + "\\" + current + ".JPG"), 50);
                                    exceptions.offer(current.toStringArrayList());
                                }
                            }
                            Web.xPath.click(driver, "/html/body/div[1]/div/div[2]/ul/li[1]/a\n");
                        }

                    } catch (Exception e){
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame,"An error has occurred while county checking " + current.toString() + "\nError: Selenium:Kane" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Lake{

            private static final String url = "https://tax.lakecountyil.gov/search/commonsearch.aspx?mode=realprop";
            private static final int implicitWait = 5;

            private Lake(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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

                        if (Web.xPath.exists(driver, "/html/body/div[1]/div[3]/section/div/form/table/tbody/tr/td/div/div/table[2]/tbody/tr/td/table/tbody/tr[3]/td/center/table[1]/tbody/tr[1]/td/div/p\n")){
                            //No result
                            Web.ID.clearTextBox(driver, "inpNo");
                            Web.ID.clearTextBox(driver, "inpStreet");
                        } else{
                            //result
                            current.setPin((Web.xPath.getText(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]\n")).split(" ")[1]);
                            current.setPropertyType(Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[15]/td[2]\n"));
                            current.setTaxCode((Web.xPath.getTextFast(driver, "/html/body/div[1]/div[3]/section/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr[25]/td[2]\n")).split(" - ")[0]);

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
                        JOptionPane.showMessageDialog(currentFrame,"An error has occurred while county checking " + current.toString() + "\nError: Selenium:Lake" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Lasalle{

            private static final String url = "http://lasallecountysa.org/propertysearch/searchaddress.aspx";
            private static final int implicitWait = 5;
            private Lasalle(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                       JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:LaSalle" + "\n" + "\nYour county check progress should have been saved");
                       return;
                   }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Kendall{

            private static final String url = "https://kendallil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Kendall(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                               current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                       System.out.println(e.getMessage());
                       e.printStackTrace();
                       undecideds.offer(current.toStringArrayList());
                       Excel.write(sourceFileName, collectionConvert(undecideds), header);
                       Excel.write(resultFileName, collectionConvert(exceptions), header);
                       JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:Kendall" + "\n" + "\nYour county check progress should have been saved");
                       return;
                   }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Grundy{

            private static final String url = "https://grundyil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Grundy(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:GRUNDY" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class StClair{

            private static final String url = "https://stclairil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private StClair(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:ST CLAIR" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Madison{

            private static final String url = "http://reweb1.co.madison.il.us/";
            private static final int implicitWait = 5;
            private Madison(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:MADISON" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Kankakee{

            private static final String url = "http://treasurer.k3county.net/";
            private static final int implicitWait = 5;
            private Kankakee(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:KANKAKEE" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
            }
        }

        public class Boone{
            private static final String url = "https://booneil.devnetwedge.com/";
            private static final int implicitWait = 5;
            private Boone(){}

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame){

                String screenshotPath = screenShotPath(resultFileName, currentFrame);

                ArrayList<String> header = (new Address()).toStringArrayList();

                Queue<ArrayList<String>> undecideds = readUndecideds(sourceFileName, currentFrame);
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
                                current.setTaxCode(Web.xPath.getTextFast(driver, "/html/body/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[4]/td[2]/div[2]\n").split(" - ")[0]);

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
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        undecideds.offer(current.toStringArrayList());
                        Excel.write(sourceFileName, collectionConvert(undecideds), header);
                        Excel.write(resultFileName, collectionConvert(exceptions), header);
                        JOptionPane.showMessageDialog(currentFrame, "An error has occurred while county checking " + current.toString() + "\nError: Selenium:BOONE" + "\n" + "\nYour county check progress should have been saved");
                        return;
                    }
                }
                Excel.write(sourceFileName, collectionConvert(undecideds), header);
                Excel.write(resultFileName, collectionConvert(exceptions), header);
                driver.close();
                JOptionPane.showMessageDialog(currentFrame, "County Check completed. " + exceptions.size() + " exceptions were found.");
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

    public static void createFolder(String folderPath, JPanel currentFrame){
        File temp = new File(folderPath);
        boolean test = temp.mkdir();
        if (!test) {
            JOptionPane.showMessageDialog(currentFrame, "Folder: '" + folderPath + "' could not be created");
        }
    }

    public static String screenShotPath(String resultFileName, JPanel currentFrame){
        String screenshotPath = resultFileName.split("\\.")[0] + "_SCREENSHOTS.";
        if (!(Files.isDirectory(Paths.get(screenshotPath)))){
            createFolder(screenshotPath, currentFrame);
        }

        return screenshotPath;
    }

    public static Queue<ArrayList<String>> readUndecideds(String sourceFileName, JPanel currentFrame){

        Queue<ArrayList<String>> undecideds = Excel.read(sourceFileName);
        try {
            if (undecideds == null) {
                throw new Exception("No undecided addresses were found");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(currentFrame, "No undecided addresses were found");
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

}
