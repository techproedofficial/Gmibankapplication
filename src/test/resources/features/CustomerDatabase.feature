@AllCustomerDB
  Feature: validate all customers using DB


    Background: create connection
      Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"


#      Connection
#          DB TYPE THEN THE HOST, DB NAME
#           username and password
#      Statement
#      RESULTSET

      Scenario Outline: db testing
        Given user gets all customer information using "<query>"
        Then user validates the data for customer
        Examples: test data
        |query|
        |Select * from tp_customer|





