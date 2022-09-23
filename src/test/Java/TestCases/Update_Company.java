package TestCases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import Functions.*;


public class Update_Company extends StartApplication{


    String dir;
    DefinitionActions company= new DefinitionActions();
    ReadFiles readingFile=new ReadFiles();
    ArrayList<String> data= new ArrayList<String>();   // Array with data of the file
    int line=1;                                  // Specific Line to read


    @BeforeTest
    public void ReadFile() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("testApp.properties"));

        dir= properties.getProperty("TestFilesPath")+"Company.txt";    // Path of the file to read
        data=readingFile.ReadSpecificLine(dir,line);                        //Read the file with data of that line

        DefinitionActions.FileName="Update_Company.json";                //JSON file that it going to read
        ExtentReportDemo.createScenario(this.getClass().getName());       //Create test scenario
    }


    @Test (priority=1)
    public void testOne() throws IOException {

        try{
            company.pressElement("Settings");
            createStep("Press the Settings Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Settings Button","FAILED");
        }
    }

    @Test (priority=2)
    public void testTwo() throws IOException {

        try{
            company.pressElement("Company Option");
            createStep("Press the Company Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Company Button","FAILED");
        }
    }

    @Test (priority=3)
    public void testThree() throws IOException {

        try{
            company.setTextField("Company Name", data.get(0));
            driver.hideKeyboard();
            createStep("Send value "+data.get(0)+" to product company name field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(0)+" to product company name field","FAILED");
        }
    }

    @Test (priority=4)
    public void testSix() throws IOException {

        try {
            company.setTextField("Company Address", data.get(1));
            driver.hideKeyboard();
            createStep("Send value "+data.get(3)+" to address field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(3)+" to address field","FAILED");
        }
    }

    @Test (priority=5)
    public void testFour() throws IOException {

        try {
            company.setTextField("Company Email", data.get(2));
            driver.hideKeyboard();
            createStep("Send value "+data.get(1)+" to email field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(1)+" to email field","FAILED");
        }
    }

    @Test (priority=6)
    public void testFive() throws IOException {

        try {
            company.setTextField("Company Phone", data.get(3));
            driver.hideKeyboard();
            createStep("Send value "+data.get(2)+" to phone field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(2)+" to phone field","FAILED");
        }
    }


    @Test (priority=7)
    public void testSeven() throws IOException {

        try{
            company.pressElement("Save");
            createStep("Press the Save Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Save Button","FAILED");
        }
    }

}