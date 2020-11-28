package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.jsonModels.StateJson;
import gmibank.pojos.States;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StatesApiSteps2 {


    Response response;
    States[] states;
    String filePath = "AllStatesData2.txt";

    @Given("user sets states to response using {string}")
    public void user_sets_states_to_response_using(String url) {
        response =given().headers(
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

    @Given("user deserializes all states to pojo")
    public void user_deserializes_all_states_to_pojo() throws Exception{
        ObjectMapper obj = new ObjectMapper();
        states = obj.readValue(response.asString(),States[].class);
        System.out.println(states[0].getName());

    }

    @Given("user generates all states' data in correspondent files")
    public void user_generates_all_states_data_in_correspondent_files() {

//        WriteToTxt.saveAllStates2(filePath,states);

    }

    @Then("user validates data for all states")
    public void user_validates_data_for_all_states() {
        List <String> list2 = new ArrayList<>();
        list2.add("Languedoc-Roussillon");
        list2.add("Ile-de-France");
        List<States> list =ReadTxt.returnAllStates2(filePath);
        String expected = "Languedoc-Roussillon";
        System.out.println(list.get(2).getName());
//        Assert.assertEquals(expected,list.get(3).getName());

        Assert.assertTrue(ReadTxt.returnAllStates3(filePath).containsAll(list2) );

    }


    @Given("user creates a new state using {string}")
    public void user_creates_a_new_state_using(String endPoint) {

        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body(StateJson.CREATE_STATE4)
                .post(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

    }



    @Given("user provides api end point to delete states using {string} and its extension {string}")
    public void user_provides_api_end_point_to_delete_states_using_and_its_extension(String endPoint, String id) {
        response = given().headers(
                "Authorization",
                "Bearer " + ConfigurationReader.getProperty("api_bearer_token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when().body(StateJson.CREATE_STATE4)
                .delete(endPoint+id)
                .then()
                .extract()
                .response();
    }



}
