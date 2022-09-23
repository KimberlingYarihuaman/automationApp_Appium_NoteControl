package Functions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;


public class ExtentReportDemo {

    ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    static public Exception e;


    @BeforeSuite
    public void reportSetup() throws IOException {

        Properties pro = new Properties();
        pro.load(new FileReader("testApp.properties"));
        String dateCurrent= new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
        spark = new ExtentSparkReporter(pro.getProperty("TestReport")+"TestReport-" +dateCurrent+".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


    public static void createScenario(String className){

        String scenarioName=getScenarioTitle(className);
        test= extent.createTest(scenarioName);
    }

    public static String getScenarioTitle(String className){

        String scenarioName=null;

        for(int i=0;i<className.length();i++){

            if(className.charAt(i)=='.'){
                scenarioName=className.substring(i+1);
            }
        }

        return scenarioName;
    }


    public static void createStep(String stepName, String status) throws IOException {

        String dest;


        if(status.equalsIgnoreCase("PASSED")){

            test.log(Status.PASS, stepName);
            dest= GetScreenShot.createScreenshot(status);
            test.log(Status.INFO, "Passed Evidence:", MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

        }else if(status.equalsIgnoreCase("FAILED")){

            test.log(Status.FAIL, stepName);
            test.log(Status.INFO, e);
            dest= GetScreenShot.createScreenshot(status);
            test.log(Status.INFO, "Failed Evidence:", MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

        }else if(status.equalsIgnoreCase("SKIPPED")){
            test.log(Status.SKIP, stepName);

        }else{
            test.log(Status.WARNING, "The scenario doesn't exist. It's UNDEFINED");

        }
    }


    @AfterTest
    public void reportTearDown(){

        extent.flush();
    }

}
