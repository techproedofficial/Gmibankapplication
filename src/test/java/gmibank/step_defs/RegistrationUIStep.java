package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;

public class RegistrationUIStep  {


    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_registration_url"));
    }

    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {
        registrationPage.ssnTextbox.sendKeys(ssn);
    }

    @Then("user enters firstname and lastname as {string} and {string}")
    public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {

        registrationPage.firstnameTextbox.sendKeys(firstname);
        registrationPage.lastnameTextbox.sendKeys(lastname);

    }

    @When("user provides address {string}")
    public void user_provides_address(String address) {
        registrationPage.addressTextbox.sendKeys(address);
    }

    @Then("user provides mobilephone as {string}")
    public void user_provides_mobilephone_as(String mobilePhone) {
        registrationPage.mobilephoneTextbox.sendKeys(mobilePhone);
    }

    @Then("user provides a username {string}")
    public void user_provides_a_username(String username) {
        registrationPage.usernameTextbox.sendKeys(username);
    }

    @Then("user provides email id as {string}")
    public void user_provides_email_id_as(String email) {
        registrationPage.emailTextbox.sendKeys(email);
    }

    @When("user enters the password as {string}")
    public void user_enters_the_password_as(String firstpassword) {
        registrationPage.firstPasswordTextbox.sendKeys(firstpassword);
    }

    @When("user confirms the new password {string}")
    public void user_confirms_the_new_password(String secondPassword) {
        registrationPage.newPasswordTextbox.sendKeys(secondPassword);
    }

    @Then("user clicks on register button and sees the success message as {string}")
    public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
        Driver.waitAndClick(registrationPage.registerButton,5);
//        registrationPage.registerButton.click();
        Assert.assertEquals("successfully registered",expectedMessage);
    }





}
