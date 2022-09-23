package Functions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;


public class DefinitionActions extends StartApplication{

    public static Properties prop=new Properties();
    static Logger log = Logger.getLogger(DefinitionActions.class.getName());
    public static String FileName = "";
    public static String GetFieldBy = "";
    public static String ValueToFind = "";



    public void setTextField(String element, String value) throws Exception {

        By AppiumElement=DefinitionActions.getCompleteElement(element);
        driver.findElement(AppiumElement).click();
        driver.findElement(AppiumElement).sendKeys(value);
        System.out.println("The text: " + value + " has been introduced in the field: " + element);

    }

    public void pressElement(String element) throws Exception {

        By AppiumElement=DefinitionActions.getCompleteElement(element);
        driver.findElement(AppiumElement).click();
        System.out.println("The element: " + element + " has been pressed.");

    }


    public void setValueList(String element, String value) throws Exception {

        By AppiumElement=DefinitionActions.getCompleteElement(element);
        driver.findElement(AppiumElement).click();

        AppiumElement=DefinitionActions.getCompleteElement(value);
        driver.findElement(AppiumElement).click();

        System.out.println("The value: " + value + " of the list: " + element + " has been selected.");

    }

    public void verticalScroll(){

        TouchAction  action =new TouchAction(driver);
        Dimension size	=driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        System.out.println("The vertical scroll has made.");

    }

    public void setDateCalendar(String element, String Button) throws Exception {

        By AppiumElement=DefinitionActions.getCompleteElement(element);
        driver.findElement(AppiumElement).click();

        AppiumElement=DefinitionActions.getCompleteElement(Button);
        driver.findElement(AppiumElement).click();

        System.out.println("The button: " + Button + " of the calendar: " + element + " has been pressed.");
    }



    public static By getCompleteElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }else if("text".equalsIgnoreCase(GetFieldBy)){
            result= MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().text(\"" + ValueToFind + "\"));");
        }else if("content-desc".equalsIgnoreCase(GetFieldBy)){
            result= MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().description(\"" + ValueToFind + "\"));");
        }

        else{
            log.info("The locator doesn't exist");
        }

        return result;
    }


    public static JSONObject ReadEntity(String element) throws Exception {
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static Object readJson() throws Exception {

        prop.load(new FileReader("testApp.properties"));
        FileReader reader = new FileReader( prop.getProperty("ViewPath")+ FileName);

        try {

            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.info("ReadEntity: The file doesn't exist" + FileName);
            throw new IllegalStateException("ReadEntity: The file doesn't exist " + FileName, e);
        }
    }



}


