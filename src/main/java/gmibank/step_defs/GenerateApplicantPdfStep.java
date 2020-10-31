package gmibank.step_defs;

import cucumber.api.java.en.Given;
import gmibank.utilities.PDFGenerator;

public class GenerateApplicantPdfStep {

    @Given("user generates pdf passing the header {string} and {string}")
    public void user_generates_pdf_passing_the_header_and(String header, String fileName) {

        PDFGenerator.pdfGeneratorRowsAndCells(header, fileName);


    }
}






