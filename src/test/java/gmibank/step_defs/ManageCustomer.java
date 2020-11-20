package gmibank.step_defs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.CommonPageElements;
import gmibank.utilities.Driver;

public class ManageCustomer {
    CommonPageElements employeePage = new CommonPageElements();
    @Then("user navigates to my operations")
    public void user_navigates_to_my_operations() {
        Driver.waitAndClick(employeePage.myOperations,5);
    }

    @When("user clicks on manageCustomer")
    public void user_clicks_on_manageCustomer() {
        Driver.waitAndClick(employeePage.manageCustomer,5);
    }

    @Then("user creates a customer")
    public void user_creates_a_customer() {
    Driver.waitAndClick(employeePage.createANewCustomer,5);

        System.out.println(employeePage.dateTextbox.getAttribute("value"));

    }

    @When("user clicks on manageAccount")
    public void user_clicks_on_manageAccount() {
        Driver.waitAndClick(employeePage.manageAccount,5);
    }

    @Then("user creates a new account")
    public void user_creates_a_new_account() {
       Driver.waitAndClick(employeePage.createANewAccount,5);
    }
}
