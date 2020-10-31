package gmibank.step_defs;

import cucumber.api.java.en.Given;
import gmibank.utilities.DatabaseUtility;

import java.util.List;

public class ResultSet {


    @Given("user gets resultSet from database using {string} , {string} and {string}")
    public void user_gets_resultSet_from_database_using_and(String url, String username, String password) {

        DatabaseUtility.createConnection(url,username,password);

        String query = "SELECT * FROM public.tp_country";

        List<Object> getRowList = DatabaseUtility.getRowList(query);

        List<Object> getColumnData =DatabaseUtility.getColumnData(query,"id");

        System.out.println(getColumnData);


    }






}
