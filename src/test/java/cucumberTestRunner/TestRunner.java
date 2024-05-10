package cucumberTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//feature"},
glue="cucumberStepDefinition",
plugin= {"pretty", "html:Reports/CucumberReport.html", 
		  "rerun:target/rerun.txt",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    	},
				
		dryRun=false,    // checks mapping between scenario steps and step definition methods
		monochrome=true,    // to avoid junk characters in output
		publish=true   // to publish report in cucumber server
		
				//tags="@smoke"  // this will execute scenarios tagged with @sanity
				//tags="@regression"
				//tags="@smoke and @regression" //Scenarios tagged with both @sanity and @regression
				//tags="@smoke and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
				//tags="@smoke or @regression" //Scenarios tagged with either @sanity or @regression
	)
public class TestRunner extends AbstractTestNGCucumberTests {

}
