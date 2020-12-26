@database
  Feature: all data validation based on DB


    Background: create a connection with DB
      Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"


      Scenario Outline: read data using column name

        Given user provides the query as "<query>" and "<columnName>"
        And user validates all db data
        Then user prints them on the pdf and close connection


        Examples: read the data
        |query|columnName|
        |Select * from tp_country|id|
        |Select * from tp_country|name|


    Scenario Outline: read data using column name

      Given user provides the query as "<query>" , columnName "<columnName>" and next "<columnName2>"
      And user validates all db data
      Then user prints them on the pdf and close connection


      Examples: read the data
        |query|columnName|columnName2|
        |Select * from tp_country|id|name|


      Scenario Outline:  read all customer info
        Given user gets all customer column data using "<query>" and "<columnName>"
        And user sets all customer info to correspondent files
        Then user validates all db Customer info

        Examples: all Customer data sets
        |query|columnName|
        |Select * from tp_customer|ssn|


        @deneme23
    Scenario Outline:  read all customer info
      Given user gets all customer column data using "<query>" and "<columnName>" and "<fileType>"
      Then user validates all db Customer info2

      Examples: all Customer data sets
        |query|columnName|fileType|
        |Select * from tp_customer|ssn|customerSSN.txt|
        |Select * from tp_customer|first_name|customerFirstNames.txt|
        |Select * from tp_customer|zip_code|customerZipCode.txt|
        |select * from tp_country |name    |countryNames.txt   |
        |Select * from tp_state   |name    |stateNames.txt     |









