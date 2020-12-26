package gmibank.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DatabaseUtility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static void createConnection() {
            String url = ConfigurationReader.getProperty("database_url");
        String user = ConfigurationReader.getProperty("database_user");
        String password = "Techpro_@126";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void createConnection(String url, String user, String password) {

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param query
     * @return returns a single cell value. If the results in multiple rows and/or
     *         columns of data, only first column of the first row will be returned.
     *         The rest of the data will be ignored
     */
    public static Object getCellValue(String query) {

        return getQueryResultList(query).get(0).get(0);
    }

    public static Object getCellValue(String query,int rowNum, int cellNum) {

        return getQueryResultList(query).get(rowNum).get(cellNum);
    }
    /**
     *
     * @param query
     * @return returns a list of Strings which represent a row of data. If the query
     *         results in multiple rows and/or columns of data, only first row will
     *         be returned. The rest of the data will be ignored
     */
    public static List<Object> getRowList(String query) {

        return getQueryResultList(query).get(0);
    }

    public static List<Object> getRowList(String query, int rowNum) {

        return getQueryResultList(query).get(rowNum);
    }
    /**
     *
     * @param query
     * @return returns a map which represent a row of data where key is the column
     *         name. If the query results in multiple rows and/or columns of data,
     *         only first row will be returned. The rest of the data will be ignored
     */
    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }
    /**
     *
     * @param query
     * @return returns query result in a list of lists where outer list represents
     *         collection of rows and inner lists represent a single row
     */
    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }
    /**
     *
     * @param query
     * @param column
     * @return list of values of a single column from the result set
     */
    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }

    public static void main(String[] args) {
        createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db","techprodb_user","Techpro_@126");
        String query ="Select * from tp_country";
//        List <Object> allIds = getColumnData(query,"name");
//        getRowList(query);
        System.out.println(getRowList(query,7));
    }
    /**
     *
     * @param query
     * @return returns query result in a list of maps where the list represents
     *         collection of rows and a map represents represent a single row with
     *         key being the column name
     */
    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }
    /**
     *
     * @param query
     * @return List of columns returned in result set
     */
    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }
    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static int getRowCount() throws Exception {
        resultSet.last();
        int rowCount = resultSet.getRow();
        return rowCount;
    }

    public static void insertCountry(String  countryName){




    }

    public static void executeInsertion(String query) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            boolean done = statement.execute(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static int getMaxCountryId (String query,String column){
        int max = 0;
        List<Object> allIds = getColumnData(query, column);

        for (int i=0; i<allIds.size();i++){
            int num = Integer.parseInt(allIds.get(i).toString().trim());
            if(max <= num)
                max=num;
        }
        return max;
    }

    public static Object getCellValuewithRowsAndCells(String query,int row,int cell) {

        return getQueryResultList(query).get(row).get(cell);
    }

    public static List<Object> getRowListWithParam(String query,int row) {

        return getQueryResultList(query).get(row);
    }

//    public static void main(String[] args) {
//        String query = "Select * from tp_customer;";
//        createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db","techprodb_user","Techpro_@126");
////        getColumnNames(query);
////        System.out.println(getColumnNames(query));
////        System.out.println(getColumnData(query, getColumnNames(query).get(3)));
////        System.out.println(getCellValuewithRowsAndCells(query,5,4));
//        List <Customer> listOfCustomers = new ArrayList<>();
//
//        List <List< Object>> list =getQueryResultList(query);
//        for (int i=0; i<20; i++){
//            Customer customer = new Customer();
//            Country country = new Country();
//            System.out.println(list.get(i).get(1));
//            customer.setFirstName(list.get(i).get(1).toString());
//            customer.setSsn(list.get(i).get(10).toString());
//            country.setName(list.get(i).get(8).toString());
//            customer.setState(list.get(i).get(14).toString());
//            customer.setZipCode(list.get(i).get(15).toString());
//            customer.setCountry(country);
//            listOfCustomers.add(customer);
//        }
//
//        PDFGenerator.pdfGeneratorRowsAndCellsWithList("All Customers!",listOfCustomers,"AllApplicants.pdf" );
//
//    }
}
