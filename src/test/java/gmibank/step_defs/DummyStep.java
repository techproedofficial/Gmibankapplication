package gmibank.step_defs;

import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DummyStep {

    @Given("user iterates over with some data")
    public void user_iterates_over_with_some_data(DataTable dataTable) {
       List<Map<String,String>> listOfMap = dataTable.asMaps();
       for (Map<String,String> eachMap :listOfMap ){

           for(String each :eachMap.keySet()){
               System.out.println(each);
               System.out.println(eachMap.get(each));
           }
       }
    }

    @Given("user types a {string} and {string}")
    public void user_types_a_and(String username, String password) {
        System.out.println("Username: "+username);
        System.out.println("password: "+password);
    }

}
