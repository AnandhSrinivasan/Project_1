package Runner_package;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/feature/Login_SpiceJet.feature"},
		//dryRun = true,
		glue = "Step_Def",
		monochrome = true,
		plugin = {"pretty",
				"html:Reports",
				"json:Reports/result.json",
				"junit:Reports/result.xml"}
				
		)


public class Runner_Class extends AbstractTestNGCucumberTests {

}
