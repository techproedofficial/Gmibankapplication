@readerOfCustomer
Feature: Read all customer data


  Background: api end point is being set in response
    Given user provides the api end point to set the response using "https://www.gmibank.com/api/tp-customers"


    Scenario: read all data coming as JSON with api
      Given user is desirializing all data to Java
      And user sets all Customer information to related files
      Then user validates allCustomer data