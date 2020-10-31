package gmibank.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features = "src/main/resources/features",
        glue = "gmibank/step_defs",
        tags = "@database",
        dryRun = false


)
public class CukesRunner {


}
