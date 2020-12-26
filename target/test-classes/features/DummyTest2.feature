Feature: datatable



  Scenario Outline: test  random data
    Given user iterates over with some data
    |username|password|
    |user1   |password1|
    |user2   |pasword2 |

    And user types a "<username>" and "<password>"

    Examples: all data
    |username|password|
    |admin   |adminpass|
    |admin2  |adminpass2|