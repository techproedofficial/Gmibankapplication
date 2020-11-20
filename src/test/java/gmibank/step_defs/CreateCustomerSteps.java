package gmibank.step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.CustomerPage;
import gmibank.utilities.Driver;

public class CreateCustomerSteps {

    CustomerPage customerPage = new CustomerPage();

    @Then("user types the ssn as {string}")
    public void user_types_the_ssn_as(String ssnForSeaerch) {
        Driver.waitAndSendText(customerPage.ssnTextbox,ssnForSeaerch,5);
    }

    @Then("user clicks on the searchbox")
    public void user_clicks_on_the_searchbox() {
       Driver.waitAndClick(customerPage.searchButton,5);
    }

    @When("user types the firstname as {string}")
    public void user_types_the_firstname_as(String firstname) {
        customerPage.firstNameTextbox.clear();
      Driver.waitAndSendText(customerPage.firstNameTextbox,firstname,5);
    }

    @Then("user also types the lastname as {string}")
    public void user_also_types_the_lastname_as(String lastname) {
        customerPage.lastNameTextbox.clear();
        Driver.waitAndSendText(customerPage.lastNameTextbox,lastname,5);
    }

    @Then("user provides the middle initial as {string}")
    public void user_provides_the_middle_initial_as(String initial) {
        customerPage.middleInitialTextbox.clear();
        Driver.waitAndSendText(customerPage.middleInitialTextbox,initial,5);

    }

    @Then("user types the email id as {string}")
    public void user_types_the_email_id_as(String email) {

        customerPage.emailTextbox.clear();
        Driver.waitAndSendText(customerPage.emailTextbox,email,5);

    }

    @Then("user types the mobilePhoneNumber as {string}")
    public void user_types_the_mobilePhoneNumber_as(String mobilePhoneNumber) {

        customerPage.mobilePhoneNumberTextbox.clear();
        Driver.waitAndSendText(customerPage.mobilePhoneNumberTextbox,mobilePhoneNumber,5);

    }

    @When("user types the actual phone number as {string}")
    public void user_types_the_actual_phone_number_as(String phoneNumber) {

        customerPage.phoneNumberTextbox.clear();
        Driver.waitAndSendText(customerPage.phoneNumberTextbox,phoneNumber,5);

    }

    @When("user types the zipCode as {string}")
    public void user_types_the_zipCode_as(String zipCode) {

        customerPage.zipCodeTextbox.clear();
        Driver.waitAndSendText(customerPage.zipCodeTextbox,zipCode,5);

    }

    @Then("user the address as {string}")
    public void user_the_address_as(String address) {
        customerPage.addressTextbox.clear();
        Driver.waitAndSendText(customerPage.addressTextbox,address,5);

    }

    @Then("user types the city as {string}")
    public void user_types_the_city_as(String city) {

        customerPage.cityTextbox.clear();
        Driver.waitAndSendText(customerPage.cityTextbox,city,5);

    }

    @Then("user types the same ssn as {string}")
    public void user_types_the_same_ssn_as(String ssn) {

        customerPage.ssnTextbox2.clear();
        Driver.waitAndSendText(customerPage.ssnTextbox2,ssn,5);
    }

    @When("user selects a country as {string}")
    public void user_selects_a_country_as(String country) {


        Driver.selectAnItemFromDropdown(customerPage.countryDropdown,country);
    }

    @When("user types the state name as {string}")
    public void user_types_the_state_name_as(String state) {

        customerPage.stateTextbox.clear();
        Driver.waitAndSendText(customerPage.stateTextbox,state,5);

    }

    @When("user selects an account from dropdown as {string}")
    public void user_selects_an_account_from_dropdown_as(String accountDropdown) {

        Driver.selectAnItemFromDropdown(customerPage.accountsDropdown,accountDropdown);

    }

}
