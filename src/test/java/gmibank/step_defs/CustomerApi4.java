package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerApi4 {


    Customer [] customers;
    Response response;
    String fileName = ConfigurationReader.getProperty("newCustomerFile");


    @Given("user provides the api end point to set the response using {string} end point")
    public void user_provides_the_api_end_point_to_set_the_response_using_end_point(String url) {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }

    @Given("user will deserialize api data to java")
    public void user_will_deserialize_api_data_to_java()throws Exception {
        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(),Customer[].class);





    }

    @Given("user saves all customer data to correspondent files")
    public void user_saves_all_customer_data_to_correspondent_files() {

//        WriteToTxt.saveAllCustomers(fileName, customers);

    }

    @Then("user validates the api data")
    public void user_validates_the_api_data() {
        List <String> currentSsnIds = new ArrayList<>();
        currentSsnIds.add("027-31-2727");
        currentSsnIds.add("498-53-5576");
        currentSsnIds.add("049-43-2360");
        List<String> appSsnIds = ReadTxt.returnCustomerSNNList(fileName);
        Assert.assertTrue("Customer info records do not match",appSsnIds.containsAll(currentSsnIds) );



    }

}
