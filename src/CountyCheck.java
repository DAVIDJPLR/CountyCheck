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

            public static void countyCheck (String sourceFileName, String resultFileName, String city, JPanel currentFrame) {

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
