Feature: Read all customer info

#  we will create a Get request using Rest Api
#  Response along with RestAssured library
#  we will create pojo classes
#  we will use ObjectMapper for deserialization
#  we will be using Bearer Token
#  finally we will do our validation

  Background: set customer data
    Given user provides the api end point to set the response using "https://www.gmibank.com/api/tp-customers" end point


    Scenario: read and validate api data
      Given user will deserialize api data to java
      And user saves all customer data to correspondent files
      Then user validates the api data


