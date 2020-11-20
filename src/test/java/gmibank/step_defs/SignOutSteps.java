package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.CommonPageElements;
import gmibank.utilities.Driver;

public class SignOutSteps {
    CommonPageElements commonPageElements = new CommonPageElements();

    @Given("user clicks on current user")
    public void user_clicks_on_current_user() {
        Driver.waitAndClick(commonPageElements.currentUserDropdown,5);
    }

    @Then("user clicks on signOut button")
    public void user_clicks_on_signOut_button() {
      Driver.waitAndClick(commonPageElements.signOutButton,5);
    }

}
