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
      When user finally validates the data with api

      Examples:
      |SSN|firstname|lastname|address|mobilephone|username|email|firstpassword|secondpassword|message|
      |123-45-2345|batch1|batch2|Gallows road 8765|321-345-2354|user2|hisetkals@gmail.com|4321user5[3]|4321user5[3]|successfully registered|
      |143-45-2345|batch11|batch2|Gallows road 8765|321-345-2354|user2|hisetkala@gmail.com|984321user5[3]|4321user5[3]|successfully registered|
      |154-45-2345|batch111|batch2|Gallows road 8765|321-345-2354|user2|hisetkalq@gmail.com|874321user5[3]|4321user5[3]|successfully registered|
      |176-45-2345|batch1111|batch2|Gallows road 8765|321-345-2354|user2|hisetkalw@gmail.com|764321user5[3]|4321user5[3]|successfully registered|
      |187-45-2345|batch11111|batch2|Gallows road 8765|321-345-2354|user2|hisetkale@gmail.com|654321user5[3]|4321user5[3]|successfully registered|
      |176-45-2345|batch111111|batch2|Gallows road 8765|321-345-2354|user2|hisetkalr@gmail.com|544321user5[3]|4321user5[3]|successfully registered|
      |125-45-2345|batch1111111|batch2|Gallows road 8765|321-345-2354|user2|hisetkalt@gmail.com|434321user5[3]|4321user5[3]|successfully registered|
      |195-45-2345|batch11111111|batch2|Gallows road 8765|321-345-2354|user2|hisetkaly@gmail.com|234321user5[3]|4321user5[3]|successfully registered|
      |189-45-2345|batch1111222|batch2|Gallows road 8765|321-345-2354|user2|hisetkalu@gmail.com|214321user5[3]|4321user5[3]|successfully registered|
      |198-45-2345|batch122222|batch2|Gallows road 8765|321-345-2354|user2|hisetkalj@gmail.com|904321user5[3]|4321user5[3]|successfully registered|
      |132-45-2345|batch1222222|batch2|Gallows road 8765|321-345-2354|user2|hisetkalb@gmail.com|784321user5[3]|4321user5[3]|successfully registered|
      |100-45-2345|batch12222222|batch2|Gallows road 8765|321-345-2354|user2|hisetkaln@gmail.com|674321user5[3]|4321user5[3]|successfully registered|
      |101-45-2345|batch122222222|batch2|Gallows road 8765|321-345-2354|user2|hisetkalm@gmail.com|456321user5[3]|4321user5[3]|successfully registered|
      |120-45-2345|batch133333333|batch2|Gallows road 8765|321-345-2354|user2|hisetkalklk@gmail.com|344321user5[3]|4321user5[3]|successfully registered|
      |109-45-2345|batch1333|batch2|Gallows road 8765|321-345-2354|user2|hisetkallku@gmail.com|4321user5[3]|024321user5[3]|successfully registered|
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
