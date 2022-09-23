package Functions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

public class GetScreenShot {

    public static WebDriver driver;
    static Properties prop = new Properties();
    static Logger log = Logger.getLogger(ExtentReportDemo.class.getName());


    public static String createScreenshot(String status) throws IOException {

        String dateCurrent, dest = null;
        File source, destination;
        TakesScreenshot ts;
        dateCurrent= new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
        prop.load(new FileReader("testApp.properties"));
        driver=DefinitionActions.driver;

        try {

            ts= (TakesScreenshot) driver;
            if(status.equalsIgnoreCase("Passed")) {

                log.info("The scenario passed.");
                dest = prop.getProperty("PassedTestEvidences") +"img_"+ dateCurrent + ".png";

            }else if (status.equalsIgnoreCase("Failed")) {

                log.info("The scenario failed.");
                dest = prop.getProperty("FailedTestEvidences") +"img_"+ dateCurrent + ".png";
            }

            //Make an image into the path (dest) of the folder
            source = ts.getScreenshotAs(OutputType.FILE);
            destination = new File(dest);
            Thread.sleep(1000);     //A second of the difference for that doesn't overwrite the images
            FileUtils.copyFile(source, destination);

        } catch (Exception e) {
            System.out.println(e);
        }

        return dest;
    }

}
