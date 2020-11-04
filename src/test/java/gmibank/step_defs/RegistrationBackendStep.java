package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gmibank.pojos.NewApplicant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class RegistrationBackendStep {
    String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYwMzE4MTQ2NX0.VioAwvkc5RbDvZ4xNERRmfAKq_iLNL8WsOVaMtbpzPy6WyvgrFsUOAw0YL2dM7EErlbLCntKH0_61Y5L6VLz0g";
    String url = "https://www.gmibank.com/api/tp-account-registrations" ;

    @When("user finally validates the data with api")
    public void user_finally_validates_the_data_with_api() throws Exception{
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

//        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();

//        AllApplicants newApplicant = obj.readValue(response.asString(),AllApplicants.class);
        NewApplicant[] newApplicants = obj.readValue(response.asByteArray(), NewApplicant[].class);

        for (int i=0; i<newApplicants.length;i++){
            System.out.println(newApplicants[i].getFirstName());
            System.out.println(newApplicants[i].getLastName());
            System.out.println(newApplicants[i].getEmail());
            System.out.println(newApplicants[i].getMobilePhoneNumber());
            System.out.println(newApplicants[i].getNewPassword());
            System.out.println(newApplicants[i].getSSN());

        }

    }


    @Given("user finally validates some data with api")
    public void user_finally_validates_some_data_with_api() throws Exception{
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

//        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();

//        AllApplicants newApplicant = obj.readValue(response.asString(),AllApplicants.class);
        NewApplicant[] newApplicants = obj.readValue(response.asByteArray(), NewApplicant[].class);

        for (int i=0; i<newApplicants.length;i++){
            System.out.println(newApplicants[i].getFirstName());
            System.out.println(newApplicants[i].getLastName());
            System.out.println(newApplicants[i].getEmail());
            System.out.println(newApplicants[i].getMobilePhoneNumber());
            System.out.println(newApplicants[i].getNewPassword());
            System.out.println(newApplicants[i].getSSN());

        }
    }

}
