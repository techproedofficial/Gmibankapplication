@AllStates
  Feature: read and delete states

    Background: set all states to response
      Given user sets all states to response using "https://www.gmibank.com/api/tp-states"


      Scenario: test all states
        Given user manipulates all states
        And user saves the states to correspondent files
        Then user validates all states


        Scenario: delete states

          Given user deletes a state using "https://www.gmibank.com/api/tp-states/19215"


    @CreateState
    Scenario Outline: create a state
      Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and creates states using "<idJson>" and "<nameJson>"



      Examples: create state
        |idJson|nameJson|
        |24118|Varsova|
#        |91040|NJ|
#        |91040|Washignton|
#        |91040|Virginia|
#        |91040|California|




    @UpdateState
    Scenario Outline: update a state
      Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and updates states using "<idJson>" and "<nameJson>"



      Examples: update state
        |idJson|nameJson|
#        |61339|North Dakota|
       |91486|VarsovaNew|


    Scenario Outline: delete more states

      Given user deletes a state using "<endPoint>" and "<id>"

      Examples: all data
      |endPoint|id|
      |https://www.gmibank.com/api/tp-states/|91486|
      |https://www.gmibank.com/api/tp-states/|91486|
      |https://www.gmibank.com/api/tp-states/|91486|
