package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.LoginPage;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class SignUpStep {

    LoginPage loginPage = new LoginPage();

    @Given("user on the sign up page")
    public void user_on_the_sign_up_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));

    }

    @Given("user provides SSN number using {string}")
    public void user_provides_SSN_number_using(String string) {

    }

    @When("customer provides firstname and password as {string} and {string}")
    public void customer_provides_firstname_and_password_as_and(String string, String string2) {

    }

    @When("customer provides {string}")
    public void customer_provides(String string) {

    }

    @Then("customer provides mobile phone as {string}")
    public void customer_provides_mobile_phone_as(String string) {

    }

    @Then("customer provides username as {string}")
    public void customer_provides_username_as(String string) {

    }

    @Then("user provides email as {string}")
    public void user_provides_email_as(String string) {

    }

    @Then("customer creates a password {string}")
    public void customer_creates_a_password(String string) {

    }

    @When("customer confirms password {string}")
    public void customer_confirms_password(String string) {

    }

    @Then("customer clicks on register button")
    public void customer_clicks_on_register_button() {

    }

    @Given("user provides username {string}and the password {string}")
    public void user_provides_username_and_the_password(String username, String password) {
        Driver.waitAndClick(loginPage.loginDropdown);
        Driver.waitAndClick(loginPage.signInButton);

        Driver.waitAndSendText(loginPage.username,username,5);
        Driver.waitAndSendText(loginPage.password,password,5);

    }

    @Then("user makes sure homepage is reachable")
    public void user_makes_sure_homepage_is_reachable(DataTable dataTable) {

       List <Map<String,String>> list = dataTable.asMaps();
       for (Map <String,String> each:list){
           for (String a : each.keySet()){
               System.out.println(a+" => "+each.get(a));
               System.out.println(a +" X "+each.get(a)+" = ");
           }
       }

        Faker faker = new Faker();
        Customer customer = new Customer();
//        customer.setFirstName(faker.name().toString());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().nameWithMiddle());
        System.out.println(faker.commerce().productName());




        Driver.waitAndClick(loginPage.loginButton);

    }


}
