package gmibank.step_defs;


import cucumber.api.java.en.Given;
public class CountryApiSteps {


    @Given("user sets the response using api end point {string} and creates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_creates_country_using_and(String url, String id, String name) {
        String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYwMjI3NjkwN30.NRU80lPHmJ79_P_bzk1VjsV4bcJ9ktvtB2QaH8av7Ua8QDFh5r2ASUbxiTsh5dTeTHlrex5dLF8RSID_yqF8MA";

//      Response response = given().headers(
//                    "Authorization",
//                    "Bearer " + bearerToken,
//                    "Content-Type",
//                    ContentType.JSON,
//                    "Accept",
//                    ContentType.JSON)
//                .when().body("{\"name\":\"SENEGAL\"}")
//                .post(url)
//                .then()
//                .contentType(ContentType.JSON)
//                .extract()
//                .response();
////                RestAssured.get("https://www.gmibank.com/api/tp-customers");
//      response.prettyPrint();
////        ObjectMapper obj = new  ObjectMapper();
    }
}
