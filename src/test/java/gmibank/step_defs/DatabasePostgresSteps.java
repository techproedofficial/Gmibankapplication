package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Country;
import gmibank.utilities.DatabaseUtility;
import gmibank.utilities.ReadTxt;

import java.util.ArrayList;
import java.util.List;

public class DatabasePostgresSteps {

    List <Country> countries = new ArrayList<>();

    @Given("user creates a connection with db using {string} , {string} and {string}")
    public void user_creates_a_connection_with_db_using_and(String port, String username, String password) {
        DatabaseUtility.createConnection(port,username,password);
    }

    @Given("user provides the query as {string} and {string}")
    public void user_provides_the_query_as_and(String query, String columnName) {

        List<Object> list = DatabaseUtility.getColumnData(query,columnName);
        Country[]countries1 = new Country[list.size()];
        for (int i=0; i<list.size()-1; i++){
           Country country  = new Country();

            if(columnName.equals("id")) {
                System.out.println("works fine");

                country.setId(Integer.parseInt(list.get(i).toString().trim()));
                countries.add(country);
                System.out.println(countries.get(i).getId());
                System.out.println(countries.size());

            }else if (columnName.equals("name") ){
                System.out.println("works fine");
                country.setName(list.get(i).toString());
                countries.add(country);
            }
        }
        System.out.println("country size: "+countries.size());


    }

    @Given("user validates all db data")
    public void user_validates_all_db_data() {
        ReadTxt.returnCustomer("AllCustomerData.txt");

    }

    @Then("user prints them on the pdf and close connection")
    public void user_prints_them_on_the_pdf_and_close_connection() {

    }


    @Given("user provides the query as {string} , columnName {string} and next {string}")
    public void user_provides_the_query_as_columnName_and_next(String query, String columnName, String columnName2) {
        List<Object> list = DatabaseUtility.getColumnData(query,columnName);
        List<Object> list2 = DatabaseUtility.getColumnData(query,columnName2);
        Country[]countries1 = new Country[list.size()];
        for (int i=0; i<list.size()-1; i++){
            Country country  = new Country();

            if(columnName.equals("id")) {
                System.out.println("works fine");

                country.setId(Integer.parseInt(list.get(i).toString().trim()));

                System.out.println(countries.get(i).getId());
                System.out.println(countries.size());
                country.setName(list.get(i).toString());
                countries.add(country);
            }
        }
        System.out.println("country size: "+countries.size());

    }





}
