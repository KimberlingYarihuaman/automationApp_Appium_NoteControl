package TestCases;

import Functions.DefinitionActions;
import Functions.ExtentReportDemo;
import Functions.StartApplication;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Add_Notes extends StartApplication {

    DefinitionActions notes= new DefinitionActions();


    @BeforeTest
    public void ReadFile() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("testApp.properties"));

        DefinitionActions.FileName="Add_Notes.json";                       //JSON file that it going to read
        ExtentReportDemo.createScenario(this.getClass().getName());       //Create test scenario
    }


    @Test(priority=1)
    public void testOne() throws IOException {

        try{
            notes.pressElement("Notes");
            createStep("Press the Notes Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Notes Button","FAILED");
        }
    }

    @Test (priority=2)
    public void testTwo() throws IOException {

        try{
            notes.pressElement("Add Notes");
            createStep("Press the Add Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Add Button","FAILED");
        }
    }

    @Test (priority=3)
    public void testThree() throws IOException {

        try{
            notes.pressElement("Add Client");
            createStep("Press the Add Client","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Add Client","FAILED");
        }
    }

    @Test (priority=4)
    public void testFour() throws IOException {

        try{
            notes.pressElement("Client Option");
            createStep("Press the client option","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the client option","FAILED");
        }
    }

    @Test (priority=5)
    public void testFive() throws IOException {

        try{
            notes.pressElement("Add Product");
            createStep("Press the Add Product Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Add Product Button","FAILED");
        }
    }

    @Test (priority=6)
    public void testSix() throws IOException {

        try{
            notes.pressElement("Product Option");
            createStep("Press the product option","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the product option","FAILED");
        }
    }

    @Test (priority=7)
    public void testSeven() throws IOException {

        try{
            notes.pressElement("Save");
            createStep("Press the Save Button","PASSED");

        }catch (Exception e){
            ExtentReportDemo.e=e;
            createStep("Press the Save Button","FAILED");
        }
    }
}
