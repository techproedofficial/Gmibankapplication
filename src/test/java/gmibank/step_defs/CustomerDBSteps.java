package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.utilities.DatabaseUtility;
import gmibank.utilities.ReadTxt;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CustomerDBSteps {

    List <Object> allSSNs = new ArrayList<>();
    List< String> listOfCurrentSSNs = new ArrayList<>();

    @Given("user reads the Customers' data using {string} and {string}")
    public void user_reads_the_Customers_data_using_and(String query, String columnName) {

        allSSNs = DatabaseUtility.getColumnData(query,columnName);
        for (int i=0; i<allSSNs.size();i++){
//            System.out.println(allSSNs.get(i).toString());
            listOfCurrentSSNs.add(allSSNs.get(i).toString().trim());
        }


    }

    @Given("user validates the customer's data")
    public void user_validates_the_customer_s_data() {
        ReadTxt.returnCustomerSNNList("NewFile.txt");
        Assert.assertTrue(listOfCurrentSSNs.containsAll(ReadTxt.returnCustomerSNNList("NewFile.txt")));
        System.out.println(listOfCurrentSSNs.containsAll(ReadTxt.returnCustomerSNNList("NewFile.txt")));
    }

    @Then("user prints all using pdf")
    public void user_prints_all_using_pdf() {


    }

}
