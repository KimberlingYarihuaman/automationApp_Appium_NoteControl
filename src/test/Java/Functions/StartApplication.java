package Functions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class StartApplication extends ExtentReportDemo{


    public static AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public AppiumDriver<MobileElement> StartApplication() throws IOException {

            DesiredCapabilities cap= new DesiredCapabilities();
            Properties properties = new Properties();
            properties.load(new FileReader("testApp.properties"));

            cap.setCapability("deviceName", properties.getProperty("deviceName"));
            cap.setCapability("automationName", properties.getProperty("automationName"));
            cap.setCapability("udid", properties.getProperty("udid"));
            cap.setCapability("platformName", properties.getProperty("platformName"));
            cap.setCapability("platformVersion", properties.getProperty("platformVersion"));
            cap.setCapability("appPackage", properties.getProperty("appPackage"));
            cap.setCapability("appActivity", properties.getProperty("appActivity"));

            URL url= new URL(properties.getProperty("URL"));
            driver = new AppiumDriver(url, cap);
            System.out.println("The application has started...");
            return driver;        //Return the application session

        }


        @AfterSuite
        public void quitDriver(){
             driver.quit();
        }

}
