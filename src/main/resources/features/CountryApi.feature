@CountryReader
  Feature: Read countries

    @api
    Scenario: Read all countries
      Given user gets all data for countries using "https://www.gmibank.com/api/tp-customers"
      And user deserializes country data as json to java pojo
      Then user validates the data


