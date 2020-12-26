package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;

import java.sql.ResultSet;
import java.sql.*;

public class DatabaseStep {

    private final static String url = "jdbc:postgresql://157.230.48.97:5432/gmibank_db";
    private final static String user = "techprodb_user";
    private final static String password = "Techpro_@126";

    @Given("user gets all data from database")
    public void user_gets_all_data_from_database() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically
            // loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC
            // drivers prior to version 4.0.
//            Class.forName("org.postgresql.Driver");
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading customer records...");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.tp_country");


            System.out.println("get all columns: ===> "+resultSet.getMetaData().getColumnCount());
            System.out.println(resultSet.getMetaData());

            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30sn", resultSet.getString("id"),
                        resultSet.getString("name"));
                System.out.println("===================");
                System.out.println(resultSet.getString(2));
            }
        } /*
         * catch (ClassNotFoundException e) {
         * System.out.println("PostgreSQL JDBC driver not found."); e.printStackTrace();
         * }
         */ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Given("user tries all necessary data of faker")
    public void user_tries_all_necessary_data_of_faker() {
        Faker faker = new Faker();
        System.out.println(faker.idNumber().ssnValid());
        System.out.println(faker.address().city());
        System.out.println(faker.address().streetAddress());
        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.internet().password(10,15,true,true));
    }

}

