@Employee
  Feature: Employee management

    @smoke
    Scenario Outline: go to registration
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in
      And user navigates to my operations
      When user clicks on manageAccount
      Then user creates a new account



      Examples:
        |username|password|
        |firstuser|123456|

    @smoke
    Scenario Outline: create a new account
      Given user types a description "<description>"
      And user types the balance as "<balance>"
      Then user selects an account type from dropdown "<accountType>"
      When user selects an accountStatusType "<accountStatusType>"
      Then user clicks on save button
      Examples: all data
      |description|balance|accountType|accountStatusType|
#      |Instructor saving account|10000|CHECKING|ACTIVE  |
#      |Instructor checking account|2000|SAVING|ACTIVE|
#      |Instructor credit card account|1000|CREDIT_CARD|ACTIVE|
#      |Instructor investing account|3000|INVESTING  |ACTIVE|

@smoke
    Scenario Outline: create a new customer
      And user navigates to my operations
      When user clicks on manageCustomer
      Then user creates a customer
      And user types the ssn as "<SSNsearch>"
      And user clicks on the searchbox
      When user types the firstname as "<firstName>"
      Then user also types the lastname as "<lastName>"
      And user provides the middle initial as "<midleInitial>"
      And user types the email id as "<email>"
      Then user types the mobilePhoneNumber as "<mobilePhoneNumber>"
      When user types the actual phone number as "<phoneNumber>"
      And user types the zipCode as "<zipCode>"
      Then user the address as "<address>"
      And user types the city as "<city>"
      And user types the same ssn as "<SSN>"
      When user selects a country as "<countryName>"
      And user types the state name as "<state>"
      When user selects an account from dropdown as "<accountDropdown>"
      Then user clicks on save button
      Examples: all data
      |SSNsearch|firstName|lastName|midleInitial|email|mobilePhoneNumber|phoneNumber|zipCode|address|city|SSN|countryName|state|accountDropdown|
      |         |         |        |            |     |                 |           |       |       |    |   |           |     |               |

