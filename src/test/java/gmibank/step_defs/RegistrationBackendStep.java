package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gmibank.pojos.NewApplicant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class RegistrationBackendStep {
    String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTYwNDYxMzE5OX0.yPsyx7OOjpNF0aCF-hx_n4g4INOVUYSal3fIIB_nCI3zMoMWQVLa3YH0A1BkGrnCHUs3PH3G2j9oH8CphVpGYA";
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


        NewApplicant[] applicantApi = obj.readValue(response.asString(),NewApplicant[].class);


//        System.out.println(applicantApi.length);
//
//
//
//
//
//
//
//
//        for (int i=0; i<applicantApi.length;i++){
//            System.out.println(applicantApi[i].getFirstname());
//            System.out.println(applicantApi[i].getLastname());
//            System.out.println(applicantApi[i].getEmail());
//            System.out.println(applicantApi[i].getMobilePhoneNumber());
//            System.out.println(applicantApi[i].getId());
//            System.out.println(applicantApi[i].getSsn());
//
//        }
    }

}
