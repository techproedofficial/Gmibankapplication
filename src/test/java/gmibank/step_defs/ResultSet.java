package gmibank.step_defs;

import cucumber.api.java.en.Given;
import gmibank.utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class ResultSet {


    @Given("user gets resultSet from database using {string} , {string} and {string}")
    public void user_gets_resultSet_from_database_using_and(String url, String username, String password) {

        DatabaseUtility.createConnection(url,username,password);

        String query = "SELECT * FROM public.tp_country";

        List<Object> getRowList = DatabaseUtility.getRowList(query);

        List<Object> getColumnData =DatabaseUtility.getColumnData(query,"id");

        System.out.println(getColumnData);
        String countryName = "NewCountry";
        String query2 = "insert into tp_country (\"id\", \"name\") values ((Select max(id) from tp_country)+1,'"+countryName+"')";
        DatabaseUtility.executeInsertion(query2);
        DatabaseUtility.closeConnection();

        


    }


    @Given("user creates a country using db {string} , {string} and {string}")
    public void user_creates_a_country_using_db_and(String url, String username, String password) {

        DatabaseUtility.createConnection(url,username,password);

        String countryName = "NewCountry";
        String query2 = "insert into tp_country (\"id\", \"name\") values ((Select max(id) from tp_country)+1,\"NewCountry\")";
        String newQuery = "Select * from tp_country";
        int countryId = DatabaseUtility.getMaxCountryId(newQuery,"id");
//        DatabaseUtility.executeInsertion(query2);
//        DatabaseUtility.closeConnection();

        System.out.println(countryId);
    }


    public static void main(String[] args) {
          Connection connection;
         Statement statement;
         java.sql.ResultSet resultSet;
    }



}
