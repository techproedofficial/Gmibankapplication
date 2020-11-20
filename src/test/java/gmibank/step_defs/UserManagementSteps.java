package gmibank.step_defs;

import cucumber.api.java.en.Given;
import gmibank.pages.CommonPageElements;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserManagementSteps {

    CommonPageElements commonPageElements = new CommonPageElements();

    @Given("user clicks on the administration dropdown")
    public void user_clicks_on_the_administration_dropdown() {
        Driver.waitAndClick(commonPageElements.administrationDropdown,5);
    }

    @Given("user clicks on the userManagement button")
    public void user_clicks_on_the_userManagement_button() {
        Driver.waitAndClick(commonPageElements.userManagementButton,5);
    }

    @Given("user gets all users from usermanagement")
    public void user_gets_all_users_from_usermanagement() {

        List<String> list = new ArrayList<>();

        for (WebElement each :commonPageElements.allUsers){
            System.out.println( each.getText());
            list.add(each.getText());
        }

        System.out.println("===============================================");
        System.out.println("list size: "+list.size());
        System.out.println(list);
        System.out.println("===============================================");

    }

}
