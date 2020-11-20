@CountryReader
  Feature: Read countries

    @api
    Scenario: Read all countries
      Given user gets all data for countries using "https://www.gmibank.com/api/tp-customers"
      And user sets all response using api end point "https://www.gmibank.com/api/tp-customers"
      And user deserializes country data as json to java pojo
      Then user validates the data



      @CreateCountry
      Scenario Outline: create a country
        Given user sets the response using api end point "https://www.gmibank.com/api/tp-customers" and creates country using "<idJson>" and "<nameJson>"


        Examples: create country
        |idJson|nameJson|
        |{\"countryId\": 5|\"name\": \"ARKANSAS\"}|

