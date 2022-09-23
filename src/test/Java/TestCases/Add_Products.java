package TestCases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import Functions.*;


public class Add_Products extends StartApplication{


    String dir;
    DefinitionActions products= new DefinitionActions();
    ReadFiles readingFile=new ReadFiles();
    ArrayList<String> data= new ArrayList<String>();   // Array with data of the file
    int line=2;                                  // Specific Line to read


    @BeforeTest
    public void ReadFile() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("testApp.properties"));

        dir= properties.getProperty("TestFilesPath")+"Products.txt";    // Path of the file to read
        data=readingFile.ReadSpecificLine(dir,line);                        //Read the file with data of that line

        DefinitionActions.FileName="Add_Products.json";                //JSON file that it going to read
        ExtentReportDemo.createScenario(this.getClass().getName());       //Create test scenario
    }


    @Test (priority=1)
    public void testOne() throws IOException {

        try{
            products.pressElement("Products");
            createStep("Press the Products Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Products Button","FAILED");
        }
    }

    @Test (priority=2)
    public void testTwo() throws IOException {

        try{
            products.pressElement("Add");
            createStep("Press the Add Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Add Button","FAILED");
        }
    }

    @Test (priority=3)
    public void testThree() throws IOException {

        try{
            products.setTextField("Product Name", data.get(0));
            driver.hideKeyboard();
            createStep("Send value "+data.get(0)+" to product name field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(0)+" to product name field","FAILED");
        }
    }

    @Test (priority=4)
    public void testFour() throws IOException {

        try {
            products.setTextField("Quantity", data.get(1));
            driver.hideKeyboard();
            createStep("Send value "+data.get(1)+" to quantity field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(1)+" to quantity field","FAILED");
        }
    }

    @Test (priority=5)
    public void testFive() throws IOException {

        try {
            products.setTextField("Purchase Price", data.get(2));
            driver.hideKeyboard();
            createStep("Send value "+data.get(2)+" to purchase price field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(2)+" to purchase price field","FAILED");
        }
    }

    @Test (priority=6)
    public void testSix() throws IOException {

        try {
            products.setTextField("Sale Price", data.get(3));
            driver.hideKeyboard();
            createStep("Send value "+data.get(3)+" to sale price field","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Send value "+data.get(3)+" to sale price field","FAILED");
        }
    }

    @Test (priority=7)
    public void testSeven() throws IOException {

        try{
            products.pressElement("Save");
            createStep("Press the Save Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Save Button","FAILED");
        }
    }

}