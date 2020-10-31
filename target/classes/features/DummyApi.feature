Feature: Dummy Test can be verified



  @accounts
  Scenario: accounts end point
    Given user verifies all accounts
    And user verifies
    Then user gets allcustomer info with user info

    @loginGMI
    Scenario Outline: go to registration
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in
      Examples:
      |username|password|
      |user    |TechUser1|

      @database
      Scenario: database testing
        Given user gets all data from database



        @pdfGenerator
        Scenario Outline: generate a pdf
          Given user generates pdf passing the header "<header>" and "<fileName>"

          Examples:
          |header|fileName|
          |Here is the info of all some users!|src/main/resources/test_data/ApplicantInfo.pdf|