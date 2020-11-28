package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CustomerApiSteps {

    Response response;
    String filePath = ConfigurationReader.getProperty("filePath_Customer");
    String bearerToken = ConfigurationReader.getProperty("api_bearer_token");
    Customer[] customers;



    @Given("user sets all response using api end point {string}")
    public void user_sets_all_response_using_api_end_point(String url) {
        System.out.println("Here is the stpe1");


        response = given().headers(
                "Authorization",
                "Bearer " + bearerToken,
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


    @Given("user deserializes country data as json to java pojo")
    public void user_deserializes_country_data_as_json_to_java_pojo()throws Exception {
        System.out.println("Here is the stpe2");

        ObjectMapper obj = new  ObjectMapper();
        customers = obj.readValue(response.asString(), Customer[].class);

        for(int i=0; i<customers.length;i++ ){
            if(customers[i].getUser() != null)
            System.out.println("id: "+ customers[i].getUser().getFirstName());
        }


    }

    @Then("user validates the data")
    public void user_validates_the_data() {
        System.out.println("Here is the stpe3");
//        WriteToTxt.returnCustomerSNN(filePath,customers[10]);

    }

}
