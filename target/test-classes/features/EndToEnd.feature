@endToEnd
  Feature: end to end workflow







    Scenario Outline: Register new users for GMI Bank
      Given user is on the registration page
      And user enters ssn number as "<SSN>"
      Then user enters firstname and lastname as "<firstname>" and "<lastname>"
      When user provides address "<address>"
      Then user provides mobilephone as "<mobilephone>"
      And user provides a username "<username>"
      Then user provides email id as "<email>"
      When user enters the password as "<firstpassword>"
      And user confirms the new password "<secondpassword>"
      Then user clicks on register button and sees the success message as "<message>"


      Examples:
        |SSN|firstname|lastname|address|mobilephone|username|email|firstpassword|secondpassword|message|
#    |393-45-5678|newUser|lastbatch|Milky way|456-679-5588|utilisateur|kalin54@gmail.com|Utilisateur123.|Utilisateur123.|successfully registered|
        |569-86-9023|utilisateur4|prenom2|New ville|798-898-8855|utilisateur4|utilisateur4@gmail.com|utilisateur4[1].|utilisateur4[1].|successfully registered|

    Scenario Outline: go to registration
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in
      And user navigates to my operations

      Examples:
        |username|password|
        |firstuser|123456|

    Scenario Outline: create a new account
      When user clicks on manageAccount
      Then user creates a new account
      Given user types a description "<description>"
      And user types the balance as "<balance>"
      Then user selects an account type from dropdown "<accountType>"
      When user selects an accountStatusType "<accountStatusType>"
      Then user clicks on save button
      Examples: all data
        |description|balance|accountType|accountStatusType|
#      |Instructor saving account|10000|CHECKING|ACTIVE  |
#      |Instructor checking account|2000|SAVING|ACTIVE|
        |utilisateur4 saving account|2000|SAVING|ACTIVE|

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
        |569-86-9023|utilisateur4|prenom2|u|utilisateur4@gmail.com|798-898-8855|798-898-8855|22180|New ville|GreensBoro|569-86-9023|UNITED STATES|NC|utilisateur4 saving account|
