package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.LoginPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;

public class LoginStep {
    LoginPage loginPage = new LoginPage();

    @Given("user goes to login page")
    public void user_goes_to_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
    }

    @Given("user provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {


        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);

    }

    @Then("user logs in")
    public void user_logs_in() {

        loginPage.loginButton.click();

    }


}
