@activateUser
  Feature: all user roles and activations


    @login
    Scenario Outline: go to registration
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in




      Examples:
        |username|password|
        |admin2|TechAdmin2|



    Scenario: find current user and assign a role
      Given user clicks on the administration dropdown
      And user clicks on the userManagement button
      And user gets all users from usermanagement