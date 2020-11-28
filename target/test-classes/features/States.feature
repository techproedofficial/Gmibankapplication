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
        |1|OHIO|



    @UpdateState
    Scenario Outline: update a state
      Given user sets the response using api end point "https://www.gmibank.com/api/tp-states" and updates states using "<idJson>" and "<nameJson>"



      Examples: create state
        |idJson|nameJson|
        |19246|GMIBank|