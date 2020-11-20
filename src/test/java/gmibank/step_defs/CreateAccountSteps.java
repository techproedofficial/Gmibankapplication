package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.ManageAccountPage;
import gmibank.utilities.Driver;

public class CreateAccountSteps {
    ManageAccountPage manageAccountPage = new ManageAccountPage();
    @Given("user types a description {string}")
    public void user_types_a_description(String description) {

        Driver.waitAndSendText(manageAccountPage.descriptionTextbox,description,5);
    }

    @Given("user types the balance as {string}")
    public void user_types_the_balance_as(String balance) {

        Driver.waitAndSendText(manageAccountPage.balanceTextbox,balance,5);
    }

    @Then("user selects an account type from dropdown {string}")
    public void user_selects_an_account_type_from_dropdown(String item) {

        Driver.selectAnItemFromDropdown(manageAccountPage.accountTypeDropdown,item);
    }

    @When("user selects an accountStatusType {string}")
    public void user_selects_an_accountStatusType(String item) {

        Driver.selectAnItemFromDropdown(manageAccountPage.accountStatusTypeDropdown,item);

    }

    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {

        Driver.waitAndClick(manageAccountPage.saveButton,5);
    }

}
