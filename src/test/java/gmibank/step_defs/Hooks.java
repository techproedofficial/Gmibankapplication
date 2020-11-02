package gmibank.step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    //@Before is similar to @BeforeMethod in TestNG
    //In our case, @Before will run before each Scenario:
    //GLOBAL Hooks Annotation
    //This will run before every scenario
    @Before(order = 1)
    public void setUp(){


    }

    //Tagged Hooks Annotation
    //This will run before any SPECIFIC SCENARIO
    @Before(order = 2)
    public void searchIphone(){

//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    //This will run After each Scenario
    @After
    public void tearDown(Scenario scenario){

        //Taking the screenshot
//        final byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        //We are embedding the screenshot as an image in our framework
//        //We SHOULD get screenshot after every FAILING Scenario
//        //Attaching the image if scenario fails
//        if (scenario.isFailed()) {
//            scenario.embed(screenshot, "image/png");
//        }
//        Driver.closeDriver();
    }

}