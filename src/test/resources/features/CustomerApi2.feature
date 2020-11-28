@AllCustomerData
  Feature: Test all customers' data

    Background: api end point is being set in response
      Given user provides the api end point to set the response using "https://www.gmibank.com/api/tp-customers"

      @customerDataTest
      Scenario: validate all customers' data
        Given manipulate all customers' data
        And user sets the data in correspondent files
        Then user validates all data


