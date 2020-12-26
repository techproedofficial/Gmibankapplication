package gmibank.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
       features = "src/test/resources/features",
        glue = "gmibank/step_defs",
        tags = "@deneme23",
        dryRun = false


)
public class CukesRunner {


}
