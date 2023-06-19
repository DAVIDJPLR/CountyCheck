import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.exit;

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

    public class Illinois {

        private Illinois(){}

        public static void countyCheck (String sourceFileName, String resultFileName, String county, String city, JPanel currentFrame){

            switch (county){
                case "WILL":
                    CountyCheck.Illinois.Will.countyCheck(sourceFileName, resultFileName, city, currentFrame);
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
                        throw new Exception("An unknown error has occurred");
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(new JPanel(), "An unknown error has occurred\nYour county check progress should have been saved");
                    exit(1);
                }
                undecideds.poll();

                Queue<ArrayList<String>> exceptions = new LinkedList<>();
                try {
                    if (Files.isRegularFile(Paths.get(resultFileName))) {
                        exceptions = Excel.read(resultFileName);
                        exceptions.poll();
                        throw new Exception("An unknown error has occurred");
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(new JPanel(), "An unknown error has occurred\nYour county check progress should have been saved");
                    exit(1);
                }

                RemoteWebDriver driver = Web.chrome(implicitWait);

                driver.get(url);

                while (!(undecideds.peek() == null)){
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
                        JOptionPane.showMessageDialog(currentFrame, "An unknown error has occurred while county checking " + current.toString() + "\nYour county check progress should have been saved");
                        exit(1);
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

}
