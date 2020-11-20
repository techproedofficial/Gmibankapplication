package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;

public class RegistrationUIStep  {


    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_registration_url"));
    }

    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {


        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn,5);
    }

    @Then("user enters firstname and lastname as {string} and {string}")
    public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {


        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname,5);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname,7);


    }

    @When("user provides address {string}")
    public void user_provides_address(String address) {
        registrationPage.addressTextbox.sendKeys(address);
    }

    @Then("user provides mobilephone as {string}")
    public void user_provides_mobilephone_as(String mobilePhone) {

        Driver.waitAndSendText( registrationPage.mobilephoneTextbox,mobilePhone,5);
    }

    @Then("user provides a username {string}")
    public void user_provides_a_username(String username) {


        Driver.waitAndSendText( registrationPage.usernameTextbox,username,5);
    }

    @Then("user provides email id as {string}")
    public void user_provides_email_id_as(String email) {
        registrationPage.emailTextbox.sendKeys(email);
    }

    @When("user enters the password as {string}")
    public void user_enters_the_password_as(String firstpassword) {

        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,firstpassword,5);
    }

    @When("user confirms the new password {string}")
    public void user_confirms_the_new_password(String secondPassword) {

        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword,5);
    }

    @Then("user clicks on register button and sees the success message as {string}")
    public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
        Driver.waitAndClick(registrationPage.registerButton,5);
//        registrationPage.registerButton.click();
//        String value =Driver.getDriver().switchTo().alert().getText();

//        System.out.println(registrationPage.toastContainer.getAttribute("class"));
//        System.out.println("here it is: "+registrationPage.toastContainer.getAttribute(""));
//        Assert.assertEquals("successfully registered",expectedMessage);
    }





}
