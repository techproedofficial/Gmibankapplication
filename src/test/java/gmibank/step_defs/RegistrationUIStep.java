package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.RegistrationPage;
import gmibank.pojos.Customer;
import gmibank.pojos.User;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.WriteToTxt;

public class RegistrationUIStep {


    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    Customer customer = new Customer();
    User user = new User();
    String fileName = ConfigurationReader.getProperty("fileNameOfCustomer");
    String firstName;
    String lastName;
    String firstPassword;
    String userName;

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_registration_url"));
    }

    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {

        ssn = faker.idNumber().ssnValid();
        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn,10);
        customer.setSsn(ssn);
    }

    @Then("user enters firstname and lastname as {string} and {string}")
    public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {

        firstname = faker.name().firstName();
        this.firstName = firstname;
        lastname = faker.name().lastName();
        this.lastName = lastname;
        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname,5);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname,7);
        customer.setFirstName(firstname);
        customer.setLastName(lastname);

    }

    @When("user provides address {string}")
    public void user_provides_address(String address) {
        address = faker.address().streetAddress();
        Driver.waitAndSendText(registrationPage.addressTextbox,address,5);
        customer.setAddress(address);
    }

    @Then("user provides mobilephone as {string}")
    public void user_provides_mobilephone_as(String mobilePhone) {
        mobilePhone = faker.phoneNumber().phoneNumber();
        Driver.waitAndSendText( registrationPage.mobilephoneTextbox,mobilePhone,5);
        customer.setMobilePhoneNumber(mobilePhone);
    }

    @Then("user provides a username {string}")
    public void user_provides_a_username(String username) {

        username = faker.name().username();
        this.userName = username;
        Driver.waitAndSendText( registrationPage.usernameTextbox,username,5);

    }

    @Then("user provides email id as {string}")
    public void user_provides_email_id_as(String email) {
        email = firstName+lastName+"@gmail.com";
        Driver.waitAndSendText(registrationPage.emailTextbox,email,5);

        customer.setEmail(email);
    }

    @When("user enters the password as {string}")
    public void user_enters_the_password_as(String firstPassword) {

        firstPassword = faker.internet().password(10,15,true,true);
        this.firstPassword = firstPassword;
        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,firstPassword,5);




    }

    @When("user confirms the new password {string}")
    public void user_confirms_the_new_password(String secondPassword) {

        secondPassword = firstPassword;
        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword,5);
    }

    @Then("user clicks on register button and sees the success message as {string}")
    public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
        Driver.waitAndClick(registrationPage.registerButton);
        WriteToTxt.saveAllCustomer(fileName, customer,firstPassword,userName );


    }





}
