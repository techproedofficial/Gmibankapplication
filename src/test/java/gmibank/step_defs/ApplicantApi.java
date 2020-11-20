package gmibank.step_defs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import gmibank.pojos.NewApplicant;
import gmibank.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.*;

import static io.restassured.RestAssured.given;

public class ApplicantApi {


    String url = "https://www.gmibank.com/api/tp-account-registrations" ;

    @Given("user creates an end-point")
    public void user_creates_an_end_point() {


    }

    @Given("user gets all data for an applicant")
    public void user_gets_all_data_for_an_applicant() throws IOException {
        Response response =given().headers(
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

//        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
//        List <String> list2 = response.jsonPath().getList("$");


        NewApplicant[] newApplicants = obj.readValue(response.asString(), NewApplicant[].class);
//        System.out.println(newApplicants[1].getApplicants());
//        System.out.println(response.asString());

//        List<NewApplicant> apps = Arrays.asList(obj.readValue(response.asString(), NewApplicant[].class));
//
//        for(NewApplicant aa : apps){
//            System.out.println(aa.getSSN());
//        }
//        AllApplicants applicants = new AllApplicants();
//        applicants.setApplicants(Arrays.asList(newApplicants));
//
//
//        for (NewApplicant each : newApplicants){
//            System.out.println(each.getSSN());
//        }


//
//
//        for( AllApplicants each : newApplicants){
//
//           NewApplicant [] applicant = each.getApplicants();
//           for (int j =0; j<applicant.length;j++){
//               System.out.println(applicant[j].getSSN());
//           }
//        }



//        List <String[]> list = TxtUtil.getAllLines();
//        for (int i = 0; i< list.size();i++ ){
//
//                String [] arr = list.get(i);
//                if(list.get(i).length > 0)
//                System.out.println(Arrays.toString(arr));
//
//        }



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
