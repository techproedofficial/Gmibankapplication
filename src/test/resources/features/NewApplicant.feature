@NewApplicants
  Feature: Register new applicants




    @registerNewUserUI
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
    |333-45-2345|Ben|Student|Long Island|689-345-2354|StakeHolder|stakeholder@gmail.com|stakeholder[1].|stakeholder[1].|successfully registered|
#    |120-45-2345|,batch133333333|,batch2|,Gallows road 8765|321-345-2354|user2|hisetkal@gmail.com|344321user5[3]|4321user5[3]|successfully registered|
#    |109-45-2345|,batch1333|,batch2|,Gallows road 8765|321-345-2354|user2|hisetkal@gmail.com|4321user5[3]|024321user5[3]|successfully registered     |




      @applicantApi
      Scenario: Just api calls for applicants
        Given user creates an end-point
        And user gets all data for an applicant


        @excelRead
        Scenario Outline: read from excel
          Given user types excel path and sheet "<path>" and "<sheet>"
        Examples:
          |path|sheet|
          |/Users/ibrahimkalin/Desktop/GMI/ Bank/GMI/ BRD.xlsx|/Users/ibrahimkalin/IdeaProjects/gmiapplication/data.txt|


    @applicant12
    Scenario: Just api calls for applicants
      Given user finally validates some data with api

