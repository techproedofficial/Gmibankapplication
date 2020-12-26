package gmibank.utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gmibank.pojos.Country;
import gmibank.pojos.Customer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PDFGenerator {



    public static void pdfGenerator(String header, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_title = header;
        List<String> headers = new ArrayList<String>();
        headers.add("Applicant");
        headers.add("SSN");
        headers.add("Country");
        headers.add("State");
        headers.add("Zip code");

        try{

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf_path));

            document.open();

            document.add(new Paragraph(pdf_title));

            PdfPTable table = new PdfPTable(5);

            table.setWidthPercentage(110);
            table.setSpacingBefore(12);
            table.setSpacingAfter(12);
            float [] colWidth = {2,2,2,2,2};
            table.setWidths(colWidth);

            for (int i=0; i<headers.size();i++){
                PdfPCell cellHeader = new PdfPCell(new Paragraph("    "+headers.get(i)));
                table.addCell(cellHeader);

            }



            document.add(table);

            document.close();

            writer.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }


    }



    public static void pdfGeneratorRowsAndCells(String header, String fileName){

        Document document = new Document();
        String pdf_path =  fileName;
        String pdf_title = header;
        String logo_path = "/Users/ibrahimkalin/Downloads/Techproed.jpg";
        List<String> headers = new ArrayList<String>();
        headers.add("Applicants");
        headers.add("SSNs");
        headers.add("Countries");
        headers.add("States");
        headers.add("Zip codes");


        List <String> rowData = new ArrayList<String>();
        rowData.add("Ibrahim");
        rowData.add("2020202202");
        rowData.add("USA");
        rowData.add("North Carolina");
        rowData.add("22180");
        rowData.add("final");



        try{

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf_path));

            document.open();

            document.add(new Paragraph("                                     "+pdf_title));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(110);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);
            float [] colWidth = {3,3,3,3,3};
            table.setWidths(colWidth);




            PdfPCell cell1 = new PdfPCell(new Phrase(headers.get(0)));
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase(headers.get(1)));
            table.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Phrase(headers.get(2)));
            table.addCell(cell3);


            PdfPCell cell4 = new PdfPCell(new Phrase(headers.get(3)));
            table.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Phrase(headers.get(4)));
            table.addCell(cell5);


            table.setHeaderRows(2);

            table.addCell(rowData.get(0));
            table.addCell(rowData.get(1));
            table.addCell(rowData.get(2));
            table.addCell(rowData.get(3));
            table.addCell(rowData.get(4));


            table.addCell("Ahmet");
            table.addCell("4278382734");
            table.addCell("USA");
            table.addCell("Virginia");
            table.addCell("55123");

            document.add(table);

            document.add(Image.getInstance(logo_path));
            document.close();

            writer.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
//        pdfGeneratorRowsAndCells("My Header","deneme.pdf");
        List<Customer> list = new ArrayList<>();
        Country country = new Country();
        country.setName("USA");
        Customer customer = new Customer();
        customer.setSsn("234-56-5678");
        customer.setFirstName("Erkan");
        customer.setState("Virginia");
        customer.setCountry(country);
        customer.setZipCode("12765");
        list.add(customer);



        pdfGeneratorRowsAndCellsWithList("UserInfo",list, "CustomerCreation.pdf");
    }

    public static void pdfGeneratorRowsAndCellsWithList(String header, List <Customer> list, String fileName){

        Document document = new Document();
        String pdf_path = fileName;
        String pdf_title = header;
        String logo_path = "/Users/ibrahimkalin/Downloads/Techproed.jpg";
        List<String> headers = new ArrayList<String>();
        headers.add("Applicants");
        headers.add("SSNs");
        headers.add("Countries");
        headers.add("States");
        headers.add("Zip codes");



        try{

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdf_path));

            document.open();

            document.add(new Paragraph("                                     "+pdf_title));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(110);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);
            float [] colWidth = {2,2,2,2,2};
            table.setWidths(colWidth);



            for(int i=0;i<headers.size();i++) {

                PdfPCell cell1 = new PdfPCell(new Phrase(headers.get(i)));
                table.addCell(cell1);

            }

            table.setHeaderRows(list.size());

            for(int i=0;i<list.size();i++ ) {

                table.addCell(list.get(i).getFirstName());
                table.addCell(list.get(i).getSsn());
                table.addCell(list.get(i).getCountry().getName());
                table.addCell(list.get(i).getState());
                table.addCell(list.get(i).getZipCode());

            }
            document.add(table);

            document.add(Image.getInstance(logo_path));
            document.close();

            writer.close();

        }

        catch(Exception e){
            e.printStackTrace();
        }


    }

//    public static void main(String[] args) {
//
//        List <Customer> list = new ArrayList<>();
//        Country country = new Country();
//        country.setName("USA");
//        Customer customer = new Customer();
//        customer.setFirstName("Emine");
//        customer.setState("MA");
//        customer.setSsn("202020202");
//        customer.setZipCode("02120");
//        customer.setCountry(country);
//
//        list.add(customer);
//
//
//
//
//
//
//
//
//
//        String header = "All Applicants Information";
//        String fileName ="applicants.pdf";
//
//
//
//
//
//
//
//        pdfGeneratorRowsAndCellsWithList(header,list,fileName);
//    }

}
