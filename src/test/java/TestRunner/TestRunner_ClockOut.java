package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = { "pretty", 
				"html:target/cucumber-reports/cucumber.html",
				"json:target/cucumber-reports/cucumber.json",
				"html:target/site/cucumber-pretty",
				"rerun:target/rerun.txt"
		        },
		monochrome =true,
		features = "src\\test\\java\\Feature_File",
		glue = { "StepDefinitions"},
		tags = "@kekaLogout",
		dryRun=false
		)


public class TestRunner_ClockOut extends AbstractTestNGCucumberTests {

}
