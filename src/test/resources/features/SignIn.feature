@SignInMultiple
  Feature: all users are to sign


    Scenario Outline: users log in
      Given user on the sign up page
      And user provides username "<username>"and the password "<password>"
      Then user makes sure homepage is reachable
      |multiplication|By|
      |1             |2 |
      |2             |2 |
      |3             |2 |
      |4             |5 |

      Examples: all user credentials
      |username|password|
      |admin2  |TechAdmin2|
