package gmibank.step_defs;

import cucumber.api.java.en.Given;
import gmibank.pojos.Country;
import gmibank.pojos.Customer;
import gmibank.utilities.PDFGenerator;

import java.util.ArrayList;
import java.util.List;

public class GenerateApplicantPdfStep {

    @Given("user generates pdf passing the header {string} and {string}")
    public void user_generates_pdf_passing_the_header_and(String header, String fileName) {

        PDFGenerator.pdfGeneratorRowsAndCells(header, fileName);


    }


    @Given("user generates pdf passing the header with a list using {string} and {string}")
    public void user_generates_pdf_passing_the_header_with_a_list_using_and(String header, String fileName) {
        Customer customer = new Customer();
        Country country = new Country();
        country.setName("USA");
        List <Customer> allCustomers = new ArrayList<>();


        customer.setFirstName("Ibrahim");
        customer.setSsn("898-67-6782");
        customer.setCountry(country);
        customer.setState("VA");
        customer.setZipCode("22180");

        allCustomers.add(customer);




       PDFGenerator.pdfGeneratorRowsAndCellsWithList(header, allCustomers,fileName);
    }



}






