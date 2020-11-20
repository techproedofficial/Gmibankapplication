package gmibank.utilities;

import gmibank.pojos.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {

    public static void saveDataInFile(String fileName, Customer customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append("\n"+customer.getFirstName()+" , "+customer.getLastName()+" , "+customer.getSsn());

            writer.close();
        } catch(IOException e){

        }
    }

}
