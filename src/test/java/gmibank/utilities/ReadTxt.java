package gmibank.utilities;

import gmibank.pojos.Customer;
import gmibank.pojos.States;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {


    public static List<Customer> returnCustomer(String filePath){
        List<Customer>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(ConfigurationReader.getProperty(filePath)))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                Customer customer = new Customer();
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                String [] each = line.split(",");
                customer.setFirstName(each[0]);
                customer.setLastName(each[1]);
                customer.setSsn(each[2]);
                all.add(customer);
            }
            String everything = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



    public static List<Customer> returnCustomerSNN(String filePath){
        List<Customer>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<Customer> readTxtData(String filePath)throws  Exception{
        List<Customer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            Customer customer = new Customer();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
//                customer.setSsn(line);

            }
            String everything = sb.toString();

            customer.setSsn(everything);
            list.add(customer);
        } finally {
            br.close();
        }
            return list;

    }

    public static List<States> returnAllStates(String filePath){
        List<States>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
             States state = new States();
             String [] allLine = line.split(",");

                int id = Integer.parseInt(allLine[1].trim());
                state.setId(id);
                state.setName(allLine[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(state);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnCustomerSNNList(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(customer.getSsn());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }


    public static List<States> returnAllStates2(String filePath){
        List<States>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
               States states = new States();
                states.setName(line.split(",")[0].trim());
                states.setId(Integer.parseInt(line.split(",")[1].trim()));
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(states);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnAllStates3(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                String temp = "";
               temp =line.split(",")[0].trim();

                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }


    public static List<String> returnAllCustomersSSNs(String filePath){
        List<String>allSSNIds = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {
                String temp = "";
                temp =line.split(",")[0].trim();

                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                allSSNIds.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allSSNIds;
    }

    public static List<Customer> returnAllCustomers(String filePath){
        List<Customer>AllCustomerInfo = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {
                Customer customer = new Customer();
                String temp = "";
                temp =line.split(",")[0].trim();

                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);
                customer.setSsn(temp);
                AllCustomerInfo.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return AllCustomerInfo;
    }

    public static Customer returnAllCustomer(String filePath){
       Customer customer = new Customer();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {

                String temp = "";
                customer.setSsn(line.split(",")[4].trim());
                customer.setEmail(line.split(",")[6].trim());
                customer.setAddress(line.split(",")[5].trim());
                customer.setFirstName(line.split(",")[2].trim());
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    public static List<String> returnAllCustomerCredentials(String filePath){
        List<String >list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {

                String username =line.split(",")[1].trim();
                String password = line.split(",")[0].trim();
               list.add(password);
               list.add(username);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public static List<Object> returnAllCustomerIds(String filePath){
        List<Object >list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {

                String id =line.split(",")[0].trim();

                list.add(id);
                sb.append(System.lineSeparator());
                line = br.readLine();




            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public static List<Object> returnAllComingFromDB(String filePath){
        List<Object >list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {

                String id =line.split(",")[0].trim();

                list.add(id);
                sb.append(System.lineSeparator());
                line = br.readLine();




            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
