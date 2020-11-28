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
      |firstUser    |firstUser123|

      @database
      Scenario: database testing
        Given user gets all data from database



        @pdfGenerator
        Scenario Outline: generate a pdf
          Given user generates pdf passing the header "<header>" and "<fileName>"

          Examples:
          |header|fileName|
          |Hello everyone!!|src/test/resources/test_data/ApplicantInfo.pdf|


  @pdfGenerator
  Scenario Outline: generate a pdf 2
    Given user generates pdf passing the header with a list using "<header>" and "<fileName>"

    Examples:
      |header|fileName|
      |Customers' Information|src/test/resources/test_data/CustomersFile.pdf|