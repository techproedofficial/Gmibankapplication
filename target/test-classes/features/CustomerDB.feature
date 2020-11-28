@CustomerDB

  Feature: validate all data of customers

    Background: create connection
      Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"

      Scenario Outline: read and validate data using DB
        Given user reads the Customers' data using "<query>" and "<column>"
        And  user validates the customer's data
        Then user prints all using pdf
        Examples: validate all
        |query|column|
        |Select * from tp_customer;|ssn|