package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import gmibank.pojos.NewApplicant;
import gmibank.utilities.TxtUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApplicantApi {

    String bearerToken ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTYwMzE4MTQ2NX0.VioAwvkc5RbDvZ4xNERRmfAKq_iLNL8WsOVaMtbpzPy6WyvgrFsUOAw0YL2dM7EErlbLCntKH0_61Y5L6VLz0g";
    String url = "https://www.gmibank.com/api/tp-account-registrations" ;

    @Given("user creates an end-point")
    public void user_creates_an_end_point() {

//        MyClass[] myObjects = mapper.readValue(json, MyClass[].class);
    }

    @Given("user gets all data for an applicant")
    public void user_gets_all_data_for_an_applicant() throws IOException {
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
//            System.out.println(newApplicants[i].getEmail());
//            System.out.println(newApplicants[i].getMobilePhoneNumber());
//            System.out.println(newApplicants[i].getNewPassword());
//            System.out.println(newApplicants[i].getSSN());

        }
        List <String[]> list = TxtUtil.getAllLines();
        for (int i = 0; i< list.size();i++ ){

                String [] arr = list.get(i);
                if(list.get(i).length > 0)
                System.out.println(Arrays.toString(arr));

        }



    }


    @Given("user types excel path and sheet {string} and {string}")
    public void user_types_excel_path_and_sheet_and(String path, String sheet) {
//        ExcelUtil excel = new ExcelUtil(path,sheet);

        File file = new File(sheet);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while(true){
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //process the line
            System.out.println(line);
        }
    }
}
