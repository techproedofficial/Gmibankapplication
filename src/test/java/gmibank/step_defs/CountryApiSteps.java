package gmibank.step_defs;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class CountryApiSteps {
    Response response;
    String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTYwNDYxMzE5OX0.yPsyx7OOjpNF0aCF-hx_n4g4INOVUYSal3fIIB_nCI3zMoMWQVLa3YH0A1BkGrnCHUs3PH3G2j9oH8CphVpGYA";


    @Given("user gets all data for countries using {string}")
    public void user_gets_all_data_for_countries_using(String url) {
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
//				RestAssured.get("https://www.gmibank.com/api/tp-customers");
		response.prettyPrint();
//		ObjectMapper obj = new  ObjectMapper();
    }

    @Given("user deserializes country data as json to java pojo")
    public void user_deserializes_country_data_as_json_to_java_pojo() {
        System.out.println("Here is the stpe2");

    }

    @Then("user validates the data")
    public void user_validates_the_data() {
        System.out.println("Here is the stpe3");

    }


}
