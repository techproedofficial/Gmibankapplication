package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerApiSteps2 {


    Response response;
    Customer[] customers;

    @Given("user provides the api end point to set the response using {string}")
    public void user_provides_the_api_end_point_to_set_the_response_using(String url) {

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

        response.prettyPrint();



    }

    @Given("manipulate all customers' data")
    public void manipulate_all_customers_data() throws Exception{

        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(),Customer[].class );
//        for (int i=0; i<customers.length;i++)
//        if(customers[i].getUser() != null)
//        System.out.println(customers[i].getUser().getFirstName());


    }

    @Given("user sets the data in correspondent files")
    public void user_sets_the_data_in_correspondent_files() {
        WriteToTxt.saveDataInFile("NewFile.txt", customers);
    }

    @Then("user validates all data")
    public void user_validates_all_data() throws Exception{
       List< Customer> list =ReadTxt.returnCustomerSNN("NewFile.txt");
       Customer customer = new Customer();
       customer.setSsn("123-47-2476");
        int count = 0;
        String expected = "111-10-1000";
        String expected2 = "098-68-1985";
        String expected3 = "777-77-7777";

       int expectedNumberOfSSN =0;
                for (int i=0; i<list.size();i++){
                    if(list.get(i).getSsn().equals(expected)){
                        System.out.println("Found item" );
                    }
                }






    }


    @Given("user is desirializing all data to Java")
    public void user_is_desirializing_all_data_to_Java()throws Exception {
        ObjectMapper obj = new ObjectMapper();

        customers = obj.readValue(response.asString(),Customer[].class);
        for (int i = 0; i < customers.length; i++) {
            System.out.println("Customer snn: "+customers[i].getSsn());
            System.out.println("First name: "+customers[i].getFirstName());
            if(customers[i].getCountry() != null)
            System.out.println("country name: "+ customers[i].getCountry().getName());
        }

    }

    @Given("user sets all Customer information to related files")
    public void user_sets_all_Customer_information_to_related_files() {
        WriteToTxt.saveAllCustomers("src/test/resources/test_data/CustomerInfo.txt",customers);
    }

    @Then("user validates allCustomer data")
    public void user_validates_allCustomer_data() {
        List <String> expectedSSNs = new ArrayList<>();

        expectedSSNs.add("244-56-7748");
        expectedSSNs.add("234-22-8998");

       List < String> allSSNs = ReadTxt.returnAllCustomersSSNs("src/test/resources/test_data/CustomerInfo.txt");
        Assert.assertTrue("All do not match",allSSNs.containsAll(expectedSSNs) );
        System.out.println("All data validation has been successful!");

    }


}
