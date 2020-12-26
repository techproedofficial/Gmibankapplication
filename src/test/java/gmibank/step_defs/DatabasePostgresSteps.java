package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pojos.Country;
import gmibank.pojos.Customer;
import gmibank.utilities.DatabaseUtility;
import gmibank.utilities.PDFGenerator;
import gmibank.utilities.ReadTxt;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DatabasePostgresSteps {

    List <Country> countries = new ArrayList<>();
    List <Object> allColumnData;

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


    @Given("user gets all customer column data using {string} and {string}")
    public void user_gets_all_customer_column_data_using_and(String query, String columnName) {

        allColumnData = DatabaseUtility.getColumnData(query,columnName);
        System.out.println(allColumnData);
    }

    @Given("user sets all customer info to correspondent files")
    public void user_sets_all_customer_info_to_correspondent_files() {
        String fileName = "allCustomerNames.txt";

//        WriteToTxt.saveAllCustomersComingFromDB(fileName,allColumnData);

    }

    @Then("user validates all db Customer info")
    public void user_validates_all_db_Customer_info() {
       List <Object> list = ReadTxt.returnAllCustomerIds("allCustomerSSNIDs.txt");
        System.out.println(list);
       List <Object> listValidate = new ArrayList<>();
        listValidate.add("324-78-4567");

        System.out.println(list);
        Assert.assertTrue("The expected names are not matching!!",list.containsAll(listValidate));
    }

    @Given("user gets all customer column data using {string} and {string} and {string}")
    public void user_gets_all_customer_column_data_using_and_and(String query, String columnName, String fileName) {
       List <Object> list = DatabaseUtility.getColumnData(query,columnName);
//        WriteToTxt.saveDifferentInfoFromDB(fileName,list);
    }

    @Given("user sets some customer info to correspondent files")
    public void user_sets_some_customer_info_to_correspondent_files() {

    }

    @Then("user validates all db Customer info{int}")
    public void user_validates_all_db_Customer_info(Integer int1) {
        List <Customer> list = new ArrayList<>();
        List <Object> SSNs = ReadTxt.returnAllComingFromDB("customerSSN.txt");
        List<Object> names = ReadTxt.returnAllComingFromDB("customerFirstNames.txt");
        List<Object> zipCodes = ReadTxt.returnAllComingFromDB("customerZipCode.txt");
        List<Object> countryNames = ReadTxt.returnAllComingFromDB("countryNames.txt");
        List<Object> stateNames = ReadTxt.returnAllComingFromDB("stateNames.txt");



        for (int i = 0; i < 5  ; i++) {
            Customer customer = new Customer();
            Country country = new Country();
            customer.setFirstName(names.get(i).toString());
            customer.setSsn(SSNs.get(i).toString());
            customer.setZipCode(zipCodes.get(i).toString());
            customer.setState(stateNames.get(i).toString());
            country.setName(countryNames.get(i).toString());

            customer.setCountry(country);
            list.add(customer);
        }

        PDFGenerator.pdfGeneratorRowsAndCellsWithList("ALlCustomers",list, "AllCustomerInfoX.pdf" );


    }



}
