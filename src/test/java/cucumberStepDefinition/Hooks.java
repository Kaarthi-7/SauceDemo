package cucumberStepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.InputDataValues;

public class Hooks {
	public static WebDriver driver;
	private static String ValidUsername;
	private static String InvalidUsername;
	private static String Password;
	private static String SortingMethod;
	private static String firstname;
	private static String Lastname;
	private static String postalcode;
	static Properties p;
	 
	@BeforeAll
   public static void setup() throws IOException, InterruptedException{
		InputDataValues IDV = new InputDataValues();
	   	driver=BaseClass.initilizeBrowser();
	   	p=BaseClass.getProperties();
	   	driver.get(p.getProperty("appURL"));
	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   	driver.manage().window().maximize();
	   	IDV.data();
	}
	
	@AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }

   @AfterAll
   public static void tearDown() {
      driver.quit();
   }

	public static String getValidUsername() {
		return ValidUsername;
	}
	
	public static String getInvalidUsername() {
		return InvalidUsername;
	}
	
	public static String getPassword() {
		return Password;
	}
	
	public static String getSortingMethod() {
		return SortingMethod;
	}
	
	public static String getFirstname() {
		return firstname;
	}
	
	public static String getLastname() {
		return Lastname;
	}
	
	public static String getPostalcode() {
		return postalcode;
	}

}