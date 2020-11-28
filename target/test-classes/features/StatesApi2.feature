@AllStates
  Feature: read, create, update and delete all states

    Background: read all states
      Given user sets states to response using "https://www.gmibank.com/api/tp-states"

      Scenario: read all states
        Given user deserializes all states to pojo
        And user generates all states' data in correspondent files
        Then user validates data for all states

        Scenario: create state
          Given user creates a new state using "https://www.gmibank.com/api/tp-states"


          Scenario Outline: delete states
            Given user provides api end point to delete states using "<endPoint>" and its extension "<id>"
            Examples: all states
            |endPoint|id|
            |https://www.gmibank.com/api/tp-states|/19213|






