package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DummyTest {



    @Given("user verifies all accounts")
    public void user_verifies_all_accounts() {

        String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYwMzE4MTQ2NX0.VioAwvkc5RbDvZ4xNERRmfAKq_iLNL8WsOVaMtbpzPy6WyvgrFsUOAw0YL2dM7EErlbLCntKH0_61Y5L6VLz0g";
      String url = "https://www.gmibank.com/api/tp-customers/accounts/1202" ;
      Response response =given().headers(
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
//        ObjectMapper obj = new  ObjectMapper();

    }


    @Given("user verifies")
    public void user_verifies() throws IOException {
        String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYwMzE4MTQ2NX0.VioAwvkc5RbDvZ4xNERRmfAKq_iLNL8WsOVaMtbpzPy6WyvgrFsUOAw0YL2dM7EErlbLCntKH0_61Y5L6VLz0g";
      String url = "https://www.gmibank.com/api/tp-customers" ;
      Response response =given().headers(
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
        ObjectMapper obj = new  ObjectMapper();

//        System.out.println(customer.getAccounts());
    }

    @Then("user gets allcustomer info with user info")
    public void user_gets_allcustomer_info_with_user_info() {

    }


}
